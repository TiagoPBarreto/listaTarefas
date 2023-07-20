package com.barreto.listatarefas

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvTasks:TextView = view.findViewById(R.id.tvTasks)
    private val cbTasks:CheckBox = view.findViewById(R.id.cbTasks)

    fun render(task: Task){
        if (task.isSelected){
            tvTasks.paintFlags = tvTasks.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
        else{
            tvTasks.paintFlags = tvTasks.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
        tvTasks.text = task.name
        cbTasks.isChecked = task.isSelected

       val color = when(task.category){
            TaskCategory.Business -> R.color.business_category
            TaskCategory.Other -> R.color.pther_category
            TaskCategory.Personal -> R.color.personal_category
        }
        cbTasks.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(cbTasks.context,color)
        )


    }
}