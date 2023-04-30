package com.mzcn.goaltracker.ui.addGoal

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddGoalViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {

    fun isValidGoal(goal: String) : Boolean{
        Log.e("girdi", "girdim")
        return goal.isNotBlank()
    }

}