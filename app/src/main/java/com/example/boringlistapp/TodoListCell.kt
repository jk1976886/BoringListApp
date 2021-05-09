package com.example.boringlistapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoListCell(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var view = itemView
    var titleTextView:TextView = itemView.findViewById(R.id.todo_list_title_view)
    var itemsTextView:TextView = itemView.findViewById(R.id.todo_list_items_view)
}