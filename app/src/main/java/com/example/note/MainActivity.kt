package com.example.note

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.note.db.MyDBManager

class MainActivity : AppCompatActivity() {

    lateinit var fbNewButton: View

    //    lateinit var edTitle: EditText
//    lateinit var edContent: EditText
//    lateinit var tvText: TextView
    val myDBManager = MyDBManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        fbNewButton = findViewById(R.id.fbNewButton)
//        edTitle = findViewById(R.id.edTitle)
//        edContent = findViewById(R.id.edContent)
//        tvText = findViewById(R.id.tvText)

        fbNewButton.setOnClickListener {
            val i = Intent(this, EditActivity::class.java)
            startActivity(i)
        }
    }

    override fun onResume() {
        super.onResume()
        myDBManager.openDB()

    }

    override fun onDestroy() {
        super.onDestroy()
        myDBManager.closeDB()
    }
}