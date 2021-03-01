package com.example.identification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.fragment.*

class id : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.Identification)

        LogBut.setOnClickListener {
            val otherActivity =  Intent(this, Activite2::class.java)
            startActivity(otherActivity)
            finish();
        }
    }
}