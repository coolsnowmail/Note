package com.example.note

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var saveButton: Button
    lateinit var edTitle: EditText
    lateinit var edContent: EditText
    lateinit var tvText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        saveButton = findViewById(R.id.buttonSave)
        edTitle = findViewById(R.id.edTitle)
        edContent = findViewById(R.id.edContent)
        tvText = findViewById(R.id.tvText)

        saveButton.setOnClickListener {
            Toast.makeText(this, "sfsdfdsfdsf", Toast.LENGTH_LONG).show()
        }
    }
}