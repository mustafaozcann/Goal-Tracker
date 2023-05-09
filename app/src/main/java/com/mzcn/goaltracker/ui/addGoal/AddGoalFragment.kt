package com.mzcn.goaltracker.ui.addGoal

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.mzcn.goaltracker.R
import com.mzcn.goaltracker.core.fragment.viewBinding
import com.mzcn.goaltracker.databinding.FragmentAddGoalBinding
import com.mzcn.goaltracker.ui.home.RecyclerItemDecoration

class AddGoalFragment : Fragment(R.layout.fragment_add_goal) {

    private val binding by viewBinding(FragmentAddGoalBinding::bind)

    private val rAdapter by lazy { RecyclerAdapter(binding) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {

            adapter = rAdapter
        }
    }
}