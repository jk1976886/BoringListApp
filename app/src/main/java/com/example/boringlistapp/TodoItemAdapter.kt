package com.example.boringlistapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TodoItemAdapter(context: Context, list:ArrayList<String>) : RecyclerView.Adapter<TodoItemCell>() {
    var context:Context = context
    var listItems:ArrayList<String> = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemCell {
        return TodoItemCell(LayoutInflater.from(context).inflate(R.layout.cell_todo_item, parent, false));
    }

    override fun onBindViewHolder(holder: TodoItemCell, position: Int) {
        holder.itemContentTextView.setText(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}