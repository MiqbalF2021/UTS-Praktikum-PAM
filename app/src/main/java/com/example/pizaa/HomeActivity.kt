package com.example.pizaa

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var storeSpinner: Spinner
    private lateinit var nameEditText: EditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        imageView = findViewById(R.id.imageView)
        storeSpinner = findViewById(R.id.store_spinner)
        nameEditText = findViewById(R.id.nameEditText)
        submitButton = findViewById(R.id.submit_button)


        val storeArray = resources.getStringArray(R.array.store_array)
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, storeArray)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        storeSpinner.adapter = spinnerAdapter


        submitButton.setOnClickListener {
            val selectedStore = storeSpinner.selectedItem.toString()
            val enteredName = nameEditText.text.toString()


            val intent = Intent(this, DetailActivity::class.java)


            intent.putExtra("selectedStore", selectedStore)
            intent.putExtra("enteredName", enteredName)


            startActivity(intent)
        }
    }
}
