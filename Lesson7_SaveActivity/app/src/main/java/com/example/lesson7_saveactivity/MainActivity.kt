package com.example.lesson7_saveactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var editText: EditText
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        button = findViewById(R.id.button)
        button.setOnClickListener {
             textView.text = editText.text
        }
    }

    fun nextAct(view: View) {
        val next = Intent(this, Someparam::class.java)
        startActivity(next)
    }

    //save 1 parametr
    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putString("KEY", textView.text.toString())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        textView.text = savedInstanceState.getString("KEY")
        super.onRestoreInstanceState(savedInstanceState)
    }
}