package com.mzcn.goaltracker.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mzcn.goaltracker.R

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.CardViewHolder>() {

    inner class CardViewHolder(view : View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.goals_recycler_row_item, parent, false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 18
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {

    }


}