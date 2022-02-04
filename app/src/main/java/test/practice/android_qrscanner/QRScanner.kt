package test.practice.android_qrscanner

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.qr_scanner.*
import test.practice.R


class QRScanner : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.qr_scanner)

        btnTakePicture.setOnClickListener {
            //startActivity(Intent(this@MainActivity, PictureBarcodeActivity::class.java))
        }

        btnScanBarcode.setOnClickListener {
            startActivity(Intent(this@QRScanner, ScannedBarcodeActivity::class.java))
        }
    }
}