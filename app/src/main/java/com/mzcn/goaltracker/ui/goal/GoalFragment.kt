package com.mzcn.goaltracker.ui.goal

import androidx.fragment.app.Fragment
import com.mzcn.goaltracker.R
import com.mzcn.goaltracker.core.fragment.viewBinding
import com.mzcn.goaltracker.databinding.FragmentGoalBinding

class GoalFragment : Fragment(R.layout.fragment_goal) {
    private val binding by viewBinding(FragmentGoalBinding::bind)
}