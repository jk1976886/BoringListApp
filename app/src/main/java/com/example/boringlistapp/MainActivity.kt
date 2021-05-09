package com.example.boringlistapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.widget.ImageView
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        supportActionBar?.hide()
        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        supportActionBar?.setDisplayShowCustomEnabled(true);
        supportActionBar?.setCustomView(R.layout.action_bar);

        setContentView(R.layout.activity_main)
        var todoListrecyclerView:RecyclerView = findViewById(R.id.TodoListRecyclerView)
        todoListrecyclerView.adapter = TodoListAdapter(this)
        todoListrecyclerView.layoutManager = LinearLayoutManager(this)
    }
}

//class TodoList{
//    var numberOfItemsToPick:Int = -1
//    var pickWithReplacement:Boolean = false
//
//    lateinit var listTitle:String
//    lateinit var listItems:ArrayList<String>
//    lateinit var resetPeriod:String
//
//    fun TodoList(context: Context){
////        val file = File(context.filesDir, "BoringListAppStoredData.txt")
//    }
//
//}