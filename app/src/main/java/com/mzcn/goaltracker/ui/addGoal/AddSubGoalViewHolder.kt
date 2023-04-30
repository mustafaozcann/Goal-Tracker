package com.mzcn.goaltracker.ui.addGoal

import android.app.Application
import android.view.LayoutInflater
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.mzcn.goaltracker.databinding.AddSubgoalRecyclerItemBinding
import com.mzcn.goaltracker.databinding.FragmentAddGoalBinding
import com.mzcn.goaltracker.databinding.LayoutAddSubgoalContainerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddSubGoalViewHolder(
    private val binding: AddSubgoalRecyclerItemBinding,
    private val containerBinding: LayoutAddSubgoalContainerBinding,
    private val addGoalBinding: FragmentAddGoalBinding
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var viewModel: AddGoalViewModel

    fun bind() {
        viewModel =
            ViewModelProvider(containerBinding.root.context as ViewModelStoreOwner)[AddGoalViewModel::class.java]
        addView(containerBinding)
    }

    private fun addView(containerBinding: LayoutAddSubgoalContainerBinding) {
        with(containerBinding) {
            addSubgoalImageButton.setOnClickListener {
                subgoalEdittextLayout.isVisible = true
                startDateEdittextLayout.isVisible = true
                endDateEdittextLayout.isVisible = true
                addSubgoalButton.isVisible = true
                addSubgoalImageButton.isVisible = false

                val goalText = addGoalBinding.goalEdittext.text.toString()

                if(viewModel.isValidGoal(goalText)){
                    addSubgoalButton.setOnClickListener {
                        val view =
                            LayoutAddSubgoalContainerBinding.inflate(LayoutInflater.from(binding.root.context))
                        addSubgoalButton.isVisible = false
                        startDateEdittextLayout.isVisible = false
                        endDateEdittextLayout.isVisible = false

                        viewModel.isValidGoal("hello")

                        addView(view)
                    }
                }


            }
        }

        binding.subGoalLayout.addView(containerBinding.root)
    }

}