package com.mzcn.goaltracker.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.mzcn.goaltracker.R
import com.mzcn.goaltracker.core.fragment.viewBinding
import com.mzcn.goaltracker.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        binding.homeFragment = this
    }
    private fun setupRecyclerView() {
        binding.goalsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = RecyclerAdapter()
        }
        PagerSnapHelper().attachToRecyclerView(binding.goalsRecyclerView)

        val pagerDecorator = CirclePagerIndicatorDecoration()
        binding.goalsRecyclerView.addItemDecoration(pagerDecorator)
    }

    fun addGoalButtonOnClick() {
        findNavController().navigate(R.id.action_homeFragment_to_goalsFragment)
    }



}