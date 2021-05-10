package com.example.boringlistapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class TodoListActivity : AppCompatActivity() {
    var listTitle:String = ""
    var numberOfItemsToPick:Int = -1
    var resetPeriod:String = ""
    var allowDuplicate:Boolean = false;
    var listTodoItemsArray:ArrayList<String> = ArrayList()
    var listCompletedItemsArray:ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseIntent()

        getSupportActionBar()?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar()?.setDisplayShowCustomEnabled(true);
        getSupportActionBar()?.setCustomView(R.layout.action_bar);

        var backButton: ImageView? = supportActionBar?.customView?.findViewById(R.id.action_bar_back_button)
        backButton?.visibility = View.VISIBLE
        backButton?.setOnClickListener {
            onBackPressed()
        }


        var titleView: TextView? = supportActionBar?.customView?.findViewById(R.id.action_bar_title)
        titleView?.text = listTitle

        var pickButton: Button? = supportActionBar?.customView?.findViewById(R.id.action_bar_pick_button)
        pickButton?.visibility = View.VISIBLE
        pickButton?.text = "Pick " + numberOfItemsToPick

        var settingsButton: ImageView? = supportActionBar?.customView?.findViewById(R.id.action_bar_settings_button)
        settingsButton?.visibility = View.VISIBLE
        settingsButton?.setOnClickListener {
            this.startActivity(Intent(this, TodoListSettingsActivity::class.java))
        }

        setContentView(R.layout.activity_todo_list)

        var todoItemsRecyclerView:RecyclerView = findViewById(R.id.todo_items_recycler_view)
        todoItemsRecyclerView.adapter = TodoItemAdapter(this, listTodoItemsArray)
        todoItemsRecyclerView.layoutManager = LinearLayoutManager(this)
        todoItemsRecyclerView.isNestedScrollingEnabled = false

        var completedItemsRecyclerView:RecyclerView = findViewById(R.id.completed_items_recycler_view)
        completedItemsRecyclerView.adapter = TodoItemAdapter(this, listCompletedItemsArray)
        completedItemsRecyclerView.layoutManager = LinearLayoutManager(this)
        completedItemsRecyclerView.isNestedScrollingEnabled = false

    }

    private fun parseIntent(){
        var intentList = intent.getStringArrayListExtra("list")

        if(intentList != null){
            listTitle = intentList[0]
            numberOfItemsToPick = intentList[1].toInt()
            resetPeriod = intentList[2]
            allowDuplicate = intentList[3].toBoolean()

            for(i in (5 until 5 + intentList[4].toInt())){
                listTodoItemsArray.add(intentList[i])
            }

            for(i in (6 + intentList[4].toInt() until intentList.size)){
                listCompletedItemsArray.add(intentList[i])
            }
        }
    }
}