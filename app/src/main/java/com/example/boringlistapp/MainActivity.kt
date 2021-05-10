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

    var fileService:FileService = FileService(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        supportActionBar?.setDisplayShowCustomEnabled(true);
        supportActionBar?.setCustomView(R.layout.action_bar);

        var pickButton:Button? = supportActionBar?.customView?.findViewById(R.id.action_bar_pick_button)
        pickButton?.visibility = View.VISIBLE
        pickButton?.text = "New List"
        pickButton?.setOnClickListener {
            //TODO create new list activity
        }

        setContentView(R.layout.activity_main)
        var todoListrecyclerView:RecyclerView = findViewById(R.id.TodoListRecyclerView)
        todoListrecyclerView.adapter = TodoListAdapter(this, fileService)
        todoListrecyclerView.layoutManager = LinearLayoutManager(this)
    }
}