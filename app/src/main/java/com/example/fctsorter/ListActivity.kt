package com.example.fctsorter

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var openDialog = Dialog(this)
       val listText: TextView = openDialog.findViewById(R.id.listText)
        listText.text = intent.getIntExtra("city",0).toString()
        setContentView(R.layout.activity_list)
    }
}