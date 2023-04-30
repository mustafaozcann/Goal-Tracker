package com.mzcn.goaltracker.ui.addGoal

import android.graphics.Color
import android.graphics.drawable.GradientDrawable.Orientation
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.mzcn.goaltracker.R
import com.mzcn.goaltracker.core.fragment.viewBinding
import com.mzcn.goaltracker.databinding.FragmentAddGoalBinding

class AddGoalFragment : Fragment(R.layout.fragment_add_goal) {
    private val binding by viewBinding(FragmentAddGoalBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = RecyclerAdapter(binding)
    }
}