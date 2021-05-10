package com.example.boringlistapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class TodoListSettingsActivity : AppCompatActivity() {
    var listTitle:String = ""
    var numberOfItemsToPick:Int = -1
    var resetPeriod:String = ""
    var allowReplacement:Boolean = false;
    var intentList:ArrayList<String> = ArrayList()
    var listTodoItemsArray:ArrayList<String> = ArrayList()
    var listCompletedItemsArray:ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseIntent()

        Log.d("Jacky", "parsedIntent")

        getSupportActionBar()?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar()?.setDisplayShowCustomEnabled(true);
        getSupportActionBar()?.setCustomView(R.layout.action_bar);

        var backButton: ImageView? = supportActionBar?.customView?.findViewById(R.id.action_bar_back_button)
        backButton?.visibility = View.VISIBLE
        backButton?.setOnClickListener {
            onBackPressed()
        }

        var titleView: TextView? = supportActionBar?.customView?.findViewById(R.id.action_bar_title)
        titleView?.text = "List Settings"

        setContentView(R.layout.activity_todo_list_settings)

        val spinner: Spinner = findViewById(R.id.reset_period_spinner)

        ArrayAdapter.createFromResource(
            this,
            R.array.reset_period_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        //TODO set spinner to saved data

        var numberOfItemsPicked:EditText = findViewById(R.id.number_of_items_picked)
//        numberOfItemsPicked.setText(numberOfItemsToPick)

        var replacementSwitch:Switch = findViewById(R.id.replacement_switch)
        replacementSwitch.isChecked = allowReplacement


    }

    private fun parseIntent(){
        intentList = intent.getStringArrayListExtra("list") as ArrayList<String>

        if(intentList != null){
            listTitle = intentList[0]
            numberOfItemsToPick = intentList[1].toInt()
            resetPeriod = intentList[2]
            allowReplacement = intentList[3].toBoolean()

            for(i in (5 until 5 + intentList[4].toInt())){
                listTodoItemsArray.add(intentList[i])
            }

            for(i in (6 + intentList[4].toInt() until intentList.size)){
                listCompletedItemsArray.add(intentList[i])
            }
        }
    }
}