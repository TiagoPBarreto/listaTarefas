package com.barreto.listatarefas

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CategoriesViewHolder(view:View) : RecyclerView.ViewHolder(view){

    private val tvCategoryName:TextView = view.findViewById(R.id.tvCategoryName)
    private val divider:View = view.findViewById(R.id.divider)
    private val viewContainer:CardView = view.findViewById(R.id.viewContainer)

    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit){

        val color = if (taskCategory.isSelected){
            R.color.background_card
        }
        else{
            R.color.background_disabled
        }

        viewContainer.setCardBackgroundColor(ContextCompat.getColor(viewContainer.context,color))

        itemView.setOnClickListener { onItemSelected(layoutPosition) }
        tvCategoryName.text = "EXEMPLO"

        when(taskCategory){
            TaskCategory.Business -> {
                tvCategoryName.text = "Negocios"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context,R.color.business_category)
                )
            }
            TaskCategory.Other -> {
                tvCategoryName.text = "Outros"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context,R.color.pther_category)
                )
            }
            TaskCategory.Personal -> {
                tvCategoryName.text = "Pessoal"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context,R.color.personal_category)
                )
            }
        }
    }
}