package com.example.identification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.view.View
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import com.google.zxing.*
import com.google.zxing.common.HybridBinarizer
import com.google.zxing.integration.android.IntentIntegrator

const val TAG: String = "TAG"
import kotlinx.android.synthetic.main.activity_scan.*
//import kotlin.Result

class ScanActivity : AppCompatActivity() {
    private var image_uri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.Identification)
    }
    setContentView(R.layout.activity_scan)

    fun onClickListener(view: View) {
        scanQRCode()
    }

    private fun scanQRCode() {
        fun setDesiredBarcodeFormats(codeTypes: Any) {

        }

        val integrator = ScanActivity(this).apply {
            FirstFragment = FirstFragment::class.java
            private fun setOrientationLocked(b: false) {
            setDesiredBarcodeFormats(ScanActivity.ALL_CODE_TYPES)
            setPrompt("Scanning Code")
            btnTakePicture.setOnClickListener {
                val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
                startActivityForResult(gallery, 1000)
            }
            btnScanBarcode.setOnClickListener {
                val intentIntegrator = ScanActivity(this)
                intentIntegrator.setBeepEnabled(false)
                intentIntegrator.setCameraId(0)
                intentIntegrator.setPrompt("SCAN")
                intentIntegrator.setBarcodeImageEnabled(false)
                intentIntegrator.initiateScan()
            }
            integrator.initiateScan()
        }

        // Get the results:
        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            val result = ScanActivity.parseActivityResult(requestCode, resultCode, data)
            if (result != null) {
                if (result.contents == null) Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
                else Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
            } else {
                super.onActivityResult(requestCode, resultCode, data)
                if (resultCode == RESULT_OK && requestCode == 1000){
                    image_uri = data?.data
                    if (image_uri != null){
                        val bitmap = BitmapFactory.decodeStream(contentResolver.openInputStream(image_uri!!))
                        val result = scanQRImage(bitmap)!!
                        Toast.makeText(this, "Scanned -> " + result.text, Toast.LENGTH_SHORT).show()
                        result_TV.text = String.format("Scanned Result: %s", result)
                        Log.e("TAAAAG", result.text)
                    }

                }
                else{
                    val result = ScanActivity.parseActivityResult(requestCode, resultCode, data)
                    if (result != null) {
                        if (result.contents == null) {
                            Toast.makeText(this, "cancelled", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Scanned -> " + result.contents, Toast.LENGTH_SHORT).show()
                            result_TV.text = String.format("Scanned Result: %s", result)
                            Log.e("TAAAAG", result.contents)
                        }
                    }
                    else {
                        super.onActivityResult(requestCode, resultCode, data)
                    }
                }
            }

            private fun scanQRImage(bMap: Bitmap): Result? {
                var contents: String? = null
                var result: Result? = null
                val intArray = IntArray(bMap.width * bMap.height)
                //copy pixel data from the Bitmap into the 'intArray' array
                bMap.getPixels(intArray, 0, bMap.width, 0, 0, bMap.width, bMap.height)
                val source: LuminanceSource = RGBLuminanceSource(bMap.width, bMap.height, intArray)
                val bitmap = BinaryBitmap(HybridBinarizer(source))
                val reader: Reader = MultiFormatReader()
                try {
                    result = reader.decode(bitmap)
                    contents = result.text
                } catch (e: Exception) {
                    Log.e("QrTest", "Error decoding barcode", e)
                }
                return result
            }
class Scan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)
    }
}

            class LuminanceSource {

            }

    class IntentIntegrator {

    }



    }



