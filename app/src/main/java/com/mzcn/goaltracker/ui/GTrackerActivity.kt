package com.mzcn.goaltracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.window.OnBackInvokedDispatcher
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.mzcn.goaltracker.R
import com.mzcn.goaltracker.databinding.ActivityMainBinding
import com.mzcn.goaltracker.ui.goals.GoalsFragment
import com.mzcn.goaltracker.ui.home.HomeFragment

class GTrackerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }
    private fun initView() = with(binding){

        val navHostFragment =
            binding.fragmentContainerView.getFragment() as NavHostFragment
        val navController = navHostFragment.navController

        setSupportActionBar(binding.materialToolbar)

        val appBarConfiguration = AppBarConfiguration(binding.bottomNavigationView.menu)

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val isVisible = destination.id != R.id.splashFragment

            binding.bottomNavigationView.isVisible = isVisible
            binding.materialToolbar.isVisible = isVisible
        }
    }
}