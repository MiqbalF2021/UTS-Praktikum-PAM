package com.example.pizaa

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val helloTextView = findViewById<TextView>(R.id.helloTextView)

        // Mengambil data yang dikirim dari DetailActivity
        val enteredName = intent.getStringExtra("enteredName")

        // Set teks "Hallo (nama)" di TextView
        helloTextView.text = "Hallo $enteredName"
    }
}
