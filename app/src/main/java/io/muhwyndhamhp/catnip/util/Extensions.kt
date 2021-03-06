package io.muhwyndhamhp.catnip.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

object Extensions {
    fun EditText.assertPassword(assert: (isValid: Boolean, reason: String?) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                var isValid = true
                var reason = ""

                when {
                    p0.isNullOrEmpty() -> {
                        isValid = false
                        reason = "Password tidak boleh kosong!"
                    }
                    p0.length < 8 -> {
                        isValid = false
                        reason = "Password minimal 8 karakter!"
                    }
                }

                assert.invoke(isValid, reason)
            }

        })
    }

    fun EditText.assertEmail(assert: (isValid: Boolean, reason: String?) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                var isValid = true
                var reason = ""

                if (p0.isNullOrEmpty()) {
                    isValid = false
                    reason = "Email tidak boleh kosong!"
                } else if (!p0.matches(Regex("(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"))) {
                    isValid = false
                    reason = "Format email tidak valid!"
                }

                assert.invoke(isValid, reason)
            }

        })
    }

}