package com.example.note

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.note.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ButtonEditImg.setOnClickListener {
            Log.d("!!!", "fddfdfdf")
            Toast.makeText(this, "dsfdfd", Toast.LENGTH_LONG).show()
        }

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.addImageButton.setOnClickListener {
            binding.mainImageLayout.visibility = View.VISIBLE
            binding.addImageButton.visibility = View.GONE
        }

        binding.ButtonDeleteImg.setOnClickListener {
            binding.addImageButton.visibility = View.VISIBLE
            binding.mainImageLayout.visibility = View.GONE
        }

    }


}