package com.example.boringlistapp

import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import java.util.stream.Stream

class TodoListAdapter(context:Context, fileService:FileService) : RecyclerView.Adapter<TodoListCell>() {
    var context:Context = context
    var fileService:FileService = fileService
    var listArray:ArrayList<ArrayList<String>> = ArrayList();

    init {
        var fileContent:String = ""
        var lines: Stream<String>? = fileService.readFromFile()
        if(lines != null){
            for(line in lines){
                var parsedList:ArrayList<String> = ArrayList()
                parsedList.addAll(line.split(","))
                listArray.add(parsedList)
            }
        }
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

    private fun composeItemText(listArray:ArrayList<String>): String {
        var combinedString:String = ""

        for (i in (5 until 5 + listArray[4].toInt())){
            if(combinedString != ""){
                combinedString += "\n"
            }
            combinedString += " - "
            combinedString += listArray[i]
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