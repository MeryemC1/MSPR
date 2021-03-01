package com.example.identification

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment.*

class Activite2 : AppCompatActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.Enregistrement)

        LogBut.setOnClickListener {
            val otherActivity =  Intent(this, Activite2::class.java)
            startActivity(otherActivity)
            finish();
        }
    }

}
