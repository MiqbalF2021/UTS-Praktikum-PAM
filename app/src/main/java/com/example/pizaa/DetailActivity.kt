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

        // Set teks "Hallo (nama)" di TextView
        val helloTextView = findViewById<TextView>(R.id.helloTextView)
        helloTextView.text = "Hallo $enteredName"

        // Set gambar toko sesuai dengan toko yang dipilih
        val storeImageView = findViewById<ImageView>(R.id.storeImageView)
        when (selectedStore) {
            "Store 1" -> storeImageView.setImageResource(R.drawable.store1_image)
            "Store 2" -> storeImageView.setImageResource(R.drawable.store2_image)
            "Store 3" -> storeImageView.setImageResource(R.drawable.store3_image)
            "Store 4" -> storeImageView.setImageResource(R.drawable.store4_image)
            // Tambahkan kasus lain sesuai dengan toko yang ada
        }

        // Handle klik tombol "See Menus" untuk navigasi ke halaman menu (MenuActivity)
        val seeMenusButton = findViewById<Button>(R.id.seeMenusButton)
        seeMenusButton.setOnClickListener {
            val selectedStore = intent.getStringExtra("selectedStore")
            val enteredName = intent.getStringExtra("enteredName")

            // Buat Intent untuk pindah ke halaman MenuActivity
            val menuIntent = Intent(this, MenuActivity::class.java)

            // Sisipkan data yang diperlukan ke Intent (jika diperlukan)
            menuIntent.putExtra("selectedStore", selectedStore)
            menuIntent.putExtra("enteredName", enteredName)

            // Navigasi ke halaman MenuActivity
            startActivity(menuIntent)
        }

    }
    }
