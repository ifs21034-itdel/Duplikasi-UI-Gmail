package com.ifs21034.gmail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val ivClose = findViewById<ImageView>(R.id.close)

        ivClose.setOnClickListener{
            finish()
        }
    }
}