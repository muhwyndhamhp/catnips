package io.muhwyndhamhp.catnip.ui

import android.content.Intent
import android.os.Bundle
import io.muhwyndhamhp.catnip.base.BaseActivity
import io.muhwyndhamhp.catnip.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity() {
    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        attachObserver()
    }

    private fun attachObserver() {
        baseViewModel.user.observe(this, {
            if (it == null) startActivity(Intent(this, LoginActivity::class.java)).also { finish() }
            else startActivity(Intent(this, MainActivity::class.java)).also { finish() }
        })
    }
}