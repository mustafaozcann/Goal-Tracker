package com.mzcn.goaltracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.mzcn.goaltracker.R
import com.mzcn.goaltracker.databinding.ActivityMainBinding

class GTrackerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }
    private fun initView() = with(binding){

        val navHostFragment =
            binding.fragmentContainerView.getFragment() as NavHostFragment
        navController = navHostFragment.navController

        setSupportActionBar(binding.materialToolbar)

        appBarConfiguration = AppBarConfiguration(binding.bottomNavigationView.menu)

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->


            val isVisible = destination.id != R.id.splashFragment


            binding.bottomNavigationView.isVisible = isVisible
            binding.materialToolbar.isVisible = isVisible
        }
    }
}