package io.muhwyndhamhp.catnip.ui

import android.os.Bundle
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import io.muhwyndhamhp.catnip.R
import io.muhwyndhamhp.catnip.base.BaseActivity
import io.muhwyndhamhp.catnip.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bttmNav, navHostFragment.navController)
    }
}