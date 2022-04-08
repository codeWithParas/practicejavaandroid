package test.practice.android_media

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_media.*
import test.practice.R

class PlayVideoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media)

        val uri: Uri = Uri.parse("android.resource://$packageName/raw/video")
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
        /*videoView.setOnPreparedListener {
            videoView.start()
        }*/
        videoView.setOnCompletionListener {

        }

    }
}