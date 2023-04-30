package com.mzcn.goaltracker.ui.addGoal

import android.app.DatePickerDialog
import android.app.Dialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.CalendarView
import android.widget.EditText
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.mzcn.goaltracker.databinding.AddSubgoalRecyclerItemBinding
import com.mzcn.goaltracker.databinding.FragmentAddGoalBinding
import com.mzcn.goaltracker.databinding.LayoutAddSubgoalContainerBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar
import java.util.Date
import javax.xml.datatype.DatatypeConstants.MONTHS

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

    private fun setDate(edittext: EditText) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


        DatePickerDialog(binding.root.context,
            { view, year, monthOfYear, dayOfMonth ->

                edittext.setText(String.format("%02d/%02d/%d", dayOfMonth, monthOfYear + 1, year))

            }, year, month, day
        ).show()
    }

    private fun addView(containerBinding: LayoutAddSubgoalContainerBinding) {
        with(containerBinding) {

            subGoalStartDateEdittext.setOnClickListener {
                setDate(it as EditText)
            }

            subGoalEndDateEdittext.setOnClickListener {
                setDate(it as EditText)
            }

            addSubgoalImageButton.setOnClickListener {
                subgoalEdittextLayout.isVisible = true
                startDateEdittextLayout.isVisible = true
                endDateEdittextLayout.isVisible = true
                addSubgoalButton.isVisible = true
                addSubgoalImageButton.isVisible = false

                val goalText = addGoalBinding.goalEdittext.text.toString()

                if (viewModel.isValidGoal(goalText)) {
                    addSubgoalButton.setOnClickListener {
                        val view =
                            LayoutAddSubgoalContainerBinding.inflate(LayoutInflater.from(binding.root.context))
                        addSubgoalButton.isVisible = false
                        startDateEdittextLayout.isVisible = false
                        endDateEdittextLayout.isVisible = false

                        viewModel.isValidGoal("hello")

                        addView(view)
                    }
                } else {
                    addGoalBinding.goalEdittextLayout.error = "Alan boş bırakılamaz !"
                }
            }
        }


        binding.subGoalLayout.addView(containerBinding.root)

    }

}