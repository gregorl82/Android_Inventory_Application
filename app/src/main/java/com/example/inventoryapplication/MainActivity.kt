package com.example.inventoryapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goToAddProduct.setOnClickListener {
            startActivity(Intent(this, AddProductActivity::class.java))
        }


        lifecycleScope.launch(Dispatchers.Default) {
            val specialMessage = URL("https://finepointmobile.com/api/inventory/v1/message").readText()
            d("gregor", "Special message is: $specialMessage")
            lastSavedProduct.text = specialMessage
        }

    }
}
