package com.example.pizaa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val intent = intent
        val selectedStore = intent.getStringExtra("selectedStore")
        val enteredName = intent.getStringExtra("enteredName")

        val helloTextView = findViewById<TextView>(R.id.helloTextView)
        helloTextView.text = "Hallo $enteredName"

        val storeImageView = findViewById<ImageView>(R.id.storeImageView)
        when (selectedStore) {
            "Store 1" -> storeImageView.setImageResource(R.drawable.store1_image)
            "Store 2" -> storeImageView.setImageResource(R.drawable.store2_image)
            "Store 3" -> storeImageView.setImageResource(R.drawable.store3_image)
            "Store 4" -> storeImageView.setImageResource(R.drawable.store4_image)
        }

        val seeMenusButton = findViewById<Button>(R.id.seeMenusButton)
        seeMenusButton.setOnClickListener {
            val selectedStore = intent.getStringExtra("selectedStore")
            val enteredName = intent.getStringExtra("enteredName")

            val menuIntent = Intent(this, MenuActivity::class.java)

            menuIntent.putExtra("selectedStore", selectedStore)
            menuIntent.putExtra("enteredName", enteredName)

            startActivity(menuIntent)
        }

    }
    }
