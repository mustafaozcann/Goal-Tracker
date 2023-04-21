package com.mzcn.goaltracker.ui.goals

import androidx.fragment.app.Fragment
import com.mzcn.goaltracker.R
import com.mzcn.goaltracker.core.fragment.viewBinding
import com.mzcn.goaltracker.databinding.FragmentGoalsBinding

class GoalsFragment : Fragment(R.layout.fragment_goals) {
    val binding by viewBinding(FragmentGoalsBinding::bind)
}