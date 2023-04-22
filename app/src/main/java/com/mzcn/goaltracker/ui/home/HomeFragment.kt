package com.mzcn.goaltracker.ui.home

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.mzcn.goaltracker.R
import com.mzcn.goaltracker.core.fragment.viewBinding
import com.mzcn.goaltracker.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
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
}