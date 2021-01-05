package io.muhwyndhamhp.catnip.ui

import android.content.Intent
import android.os.Bundle
import io.muhwyndhamhp.catnip.base.BaseActivity
import io.muhwyndhamhp.catnip.databinding.ActivityLoginBinding
import io.muhwyndhamhp.catnip.util.Extensions.assertEmail
import io.muhwyndhamhp.catnip.util.Extensions.assertPassword

class LoginActivity : BaseActivity() {
    lateinit var binding: ActivityLoginBinding

    private var emailValid = false
    private var passwordValid = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        attachEditTextAssertion()
        attachButtonListener()
        attachObserver()
    }

    private fun attachObserver() {
        baseViewModel.user.observe(this, {
            if (it != null) baseViewModel.prepopulateDatabase()
        })

        baseViewModel.catList.observe(this, {
            if (!it.isNullOrEmpty()) {
                startActivity(Intent(this, MainActivity::class.java))
            }
        })
    }

    private fun attachButtonListener() {
        binding.btnLogin.setOnClickListener {
            if (emailValid && passwordValid)
                baseViewModel.insertUser(
                    binding.etEmail.text.toString(),
                    binding.etPassword.text.toString()
                )
            else {
                if (!emailValid) binding.tilEmail.error =
                    "Email harus valid dan tidak boleh kosong!"
                else binding.tilEmail.error = null

                if (!passwordValid) binding.tilPassword.error = "Password minimal 8 karakter!"
                else binding.tilPassword.error = null
            }
        }
    }

    private fun attachEditTextAssertion() {
        binding.etEmail.assertEmail { isValid, reason ->
            if (!isValid) binding.tilEmail.error = reason
            else binding.tilEmail.error = null

            emailValid = isValid
            updateLoginButton()
        }

        binding.etPassword.assertPassword { isValid, reason ->
            if (!isValid) binding.tilPassword.error = reason
            else binding.tilPassword.error = null

            passwordValid = isValid
            updateLoginButton()
        }
    }

    private fun updateLoginButton() {
        binding.btnLogin.isEnabled = emailValid && passwordValid
    }
}