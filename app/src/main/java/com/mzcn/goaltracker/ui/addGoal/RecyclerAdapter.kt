package com.mzcn.goaltracker.ui.addGoal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mzcn.goaltracker.databinding.AddSubgoalRecyclerItemBinding
import com.mzcn.goaltracker.databinding.FragmentAddGoalBinding
import com.mzcn.goaltracker.databinding.LayoutAddSubgoalContainerBinding

class RecyclerAdapter(private val goalBinding: FragmentAddGoalBinding) : RecyclerView.Adapter<AddSubGoalViewHolder>() {

    private lateinit var binding: AddSubgoalRecyclerItemBinding
    private lateinit var containerBinding: LayoutAddSubgoalContainerBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddSubGoalViewHolder {
        binding =
            AddSubgoalRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        containerBinding = LayoutAddSubgoalContainerBinding.inflate(
            LayoutInflater.from(binding.root.context),
            binding.root,
            false
        )
        return AddSubGoalViewHolder(binding, containerBinding, goalBinding)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: AddSubGoalViewHolder, position: Int) {
        holder.bind()
    }


}

