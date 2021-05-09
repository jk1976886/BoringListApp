package com.example.boringlistapp

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class TodoListSettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.reset_period_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

    }
}