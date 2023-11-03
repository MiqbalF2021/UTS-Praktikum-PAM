package com.example.pizaa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MenuDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_detail)

        val menuTitle = intent.getStringExtra("menuTitle")
        val menuDescription = intent.getStringExtra("menuDescription")
        val imageResName = intent.getStringExtra("menuImageResName")

        val titleTextView = findViewById<TextView>(R.id.menuTitleTextView)
        val descriptionTextView = findViewById<TextView>(R.id.menuDescriptionTextView)
        val imageView = findViewById<ImageView>(R.id.menuImageView)

        titleTextView.text = menuTitle
        descriptionTextView.text = menuDescription

        val imageResId = resources.getIdentifier(imageResName, "drawable", packageName)
        imageView.setImageResource(imageResId)

        val orderButton = findViewById<Button>(R.id.order)
        val backButton = findViewById<Button>(R.id.back)

        orderButton.setOnClickListener {
            showOrderDetail()
        }

        backButton.setOnClickListener {
            // Kembali ke halaman sebelumnya (misalnya, MenuActivity)
            onBackPressed()
        }
    }

    private fun showOrderDetail() {
        val selectedStore = intent.getStringExtra("selectedStore")
        val enteredName = intent.getStringExtra("enteredName")
        val menuTitle = intent.getStringExtra("menuTitle")

        val intent = Intent(this, OrderActivity::class.java)
        intent.putExtra("selectedStore", selectedStore)
        intent.putExtra("enteredName", enteredName)
        intent.putExtra("orderedMenu", menuTitle) // Mengirimkan judul menu sebagai menu yang dipesan
        startActivity(intent)
    }
}

