package com.example.pizaa

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val helloTextView = findViewById<TextView>(R.id.helloTextView)


        val enteredName = intent.getStringExtra("enteredName")


        helloTextView.text = "Hallo $enteredName"


        val menuTitles = resources.getStringArray(R.array.menu_titles)
        val menuDescriptions = resources.getStringArray(R.array.menu_descriptions)

        for (i in 1..4) {
            val menuTitleResId = resources.getIdentifier("menuTitle$i", "id", packageName)
            val menuDescriptionResId = resources.getIdentifier("menuDeskripsi$i", "id", packageName)
            val menuImageResName = "menu$i"

            findViewById<TextView>(menuTitleResId).text = menuTitles[i - 1]
            findViewById<TextView>(menuDescriptionResId).text = menuDescriptions[i - 1]


            findViewById<View>(menuTitleResId).setOnClickListener {

                showMenuDetail(menuTitles[i - 1], menuDescriptions[i - 1], menuImageResName)
            }
        }
    }

    private fun showMenuDetail(title: String, description: String, imageResName: String) {
        val selectedStore = intent.getStringExtra("selectedStore")
        val enteredName = intent.getStringExtra("enteredName")


        val intent = Intent(this, MenuDetailActivity::class.java)


        intent.putExtra("selectedStore", selectedStore)
        intent.putExtra("enteredName", enteredName)
        intent.putExtra("menuTitle", title)
        intent.putExtra("menuDescription", description)
        intent.putExtra("menuImageResName", imageResName)


        startActivity(intent)
    }

    private fun showOrderDetail() {

        val selectedStore = intent.getStringExtra("selectedStore")
        val enteredName = intent.getStringExtra("enteredName")


        val intent = Intent(this, OrderActivity::class.java)
        intent.putExtra("selectedStore", selectedStore)
        intent.putExtra("enteredName", enteredName)

        intent.putExtra("orderedMenu", "Menu yang dipesan") // Gantilah dengan daftar menu yang dipesan

        startActivity(intent)
    }
}
