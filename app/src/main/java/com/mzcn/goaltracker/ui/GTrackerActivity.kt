package com.mzcn.goaltracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.window.OnBackInvokedDispatcher
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.AppBarLayout
import com.mzcn.goaltracker.R
import com.mzcn.goaltracker.databinding.ActivityMainBinding
import com.mzcn.goaltracker.ui.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GTrackerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() = with(binding) {
        val navHostFragment =
            binding.fragmentContainerView.getFragment() as NavHostFragment
        navController = navHostFragment.navController

        setSupportActionBar(binding.materialToolbar)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val toolBarIsVisible = destination.id != R.id.splashFragment

            binding.materialToolbar.apply {
                isVisible = toolBarIsVisible
                title = destination.label.toString()
                if (isVisible && destination.id != R.id.homeFragment) {
                    setNavigationIcon(R.drawable.ic_back_button)
                    setNavigationOnClickListener {
                        // Geri butonuna tıklandığında yapılacak işlemler
                        onBackPressedDispatcher.onBackPressed()
                    }
                } else {
                    setNavigationIcon(null)

                }
            }

        }
    }
}