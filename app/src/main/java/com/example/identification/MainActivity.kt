package com.example.identification

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.Enregistrement)
    }

    fun onClickBtnPlay(view:View) {
        val intent = Intent(this, Identification::class.java)
        startActivity(intent)
    }
}

class Identification {

}
