package com.example.boringlistapp

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TodoListAdapter(context:Context) : RecyclerView.Adapter<TodoListCell>() {
    var context:Context = context
    //For now, lists are an array of array, where First Item = Title. No list settings are stored.
    var listArray:ArrayList<ArrayList<String>> = ArrayList();

    init {
        setListArray()
    }

    private fun setListArray(){
        for(i in (1..10)){
            var aList:ArrayList<String> = ArrayList()
            aList.add("List Title " + i)
            for(ii in (1..10)){
                aList.add("List " + i + " item " + ii)
            }
            listArray.add(aList)
        }
    }

    private fun composeItemText(listItemsArray:ArrayList<String>): String {
        var combinedString:String = ""

        for (i in (1 until listItemsArray.size)){
            if(i != 1){
                combinedString += "\n"
            }
            combinedString += " - "
            combinedString += listItemsArray[i]
        }
        return combinedString
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListCell {
        return TodoListCell(LayoutInflater.from(context).inflate(R.layout.cell_todo_list, parent, false))
    }

    override fun onBindViewHolder(holder: TodoListCell, position: Int) {
        holder.titleTextView.setText(listArray[position][0])
        holder.itemsTextView.setText(composeItemText(listArray[position]))

        holder.view.setOnClickListener(View.OnClickListener {
            context.startActivity(Intent(context, TodoListActivity::class.java).putExtra("list", listArray[position]))
        })
    }

    override fun getItemCount(): Int {
        return listArray.size;
    }
}