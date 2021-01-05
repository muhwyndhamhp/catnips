package io.muhwyndhamhp.catnip.base

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity() {
    val baseViewModel : BaseViewModel by viewModels()
}