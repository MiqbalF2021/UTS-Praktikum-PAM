package com.example.pizaa


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val nameTextView = findViewById<TextView>(R.id.nameTextView)
        val storeTextView = findViewById<TextView>(R.id.storeTextView)
        val deliveryRadioGroup = findViewById<RadioGroup>(R.id.deliveryRadioGroup)
        val confirmOrderButton = findViewById<Button>(R.id.confirmOrderButton)
        val orderDetailTextView = findViewById<TextView>(R.id.orderDetailTextView)


        val enteredName = intent.getStringExtra("enteredName")
        val selectedStore = intent.getStringExtra("selectedStore")
        val orderedMenu = intent.getStringExtra("orderedMenu")


        nameTextView.text = "Name: $enteredName"
        storeTextView.text = "Store: $selectedStore"
        orderDetailTextView.text =
            "Ordered Menu: $orderedMenu"

        confirmOrderButton.setOnClickListener {
            val homeIntent = Intent(this, HomeActivity::class.java)
            startActivity(homeIntent)
        }

    }
}