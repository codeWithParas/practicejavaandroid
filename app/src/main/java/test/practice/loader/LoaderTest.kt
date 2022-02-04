package test.practice.loader

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_loader.*
import test.practice.R

class LoaderTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loader)

        Glide
            .with(this)
            .load(R.drawable.animationgif)
            .into(imgView)

        //this.addView(bounceLoader)
    }
}