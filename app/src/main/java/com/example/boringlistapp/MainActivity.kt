package com.example.boringlistapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import java.io.File

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        supportActionBar?.setDisplayShowCustomEnabled(true);
        supportActionBar?.setCustomView(R.layout.action_bar);

        var pickButton:Button? = supportActionBar?.customView?.findViewById(R.id.action_bar_pick_button)
        pickButton?.visibility = View.VISIBLE
        pickButton?.text = "New List"
        pickButton?.setOnClickListener {
            //create new list activity
        }

        //I want every LINE to be a list.
        //Every list is json like formatted, containing TITLE, num items picked, reset period, replacement,
        //THEN num of todo items, then todo items, then num of completed items, then completed items
        saveAFile("Jacky Title,5,day,false,3,Jacky TODO 1,Jacky TODO 2,Jacky TODO 3,2,Jacky COMPLETED 1,Jacky COMPLETED 2\nJacky Title 2,4,month,true,1,Jacky TODO for List 2,2,I finished this,I finished that")

        setContentView(R.layout.activity_main)
        var todoListrecyclerView:RecyclerView = findViewById(R.id.TodoListRecyclerView)
        todoListrecyclerView.adapter = TodoListAdapter(this)
        todoListrecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun printAllFiles(){
        for(fileName in this.fileList()){
            Log.d("Jacky", fileName)
        }
    }

    private fun readAFile(){
        Log.d("Jacky", "readAFile")

        this.openFileInput("SavedLists").bufferedReader().useLines {
            for(str in it){
                Log.d("Jacky", str)
            }
        }
        Log.d("Jacky", "readAFile END")
    }

    private fun saveAFile(str:String){
        Log.d("Jacky", "saveAFile")

        this.openFileOutput("SavedLists", Context.MODE_PRIVATE).use{
            it.write(str.toByteArray())
        }

        Log.d("Jacky", "saveAFile END")
    }
}