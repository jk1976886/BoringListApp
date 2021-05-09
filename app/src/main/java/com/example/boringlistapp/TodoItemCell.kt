package com.example.boringlistapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoItemCell(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var itemView = itemView
    var itemContentTextView: TextView = itemView.findViewById(R.id.item_content_text_view)
}