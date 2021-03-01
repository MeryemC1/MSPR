package com.example.identification
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class SecActivity {



    class ProductsActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_scan)

        }

        fun onClickBtnPlay(view: View) {
            val intent = Intent(this, ScanActivity::class.java)
            startActivity(intent)
        }

    }
}

abstract class ProductItemAdapter(activity: SecActivity.ProductsActivity, list: MutableList<Product>) :
    ListAdapter {

}
