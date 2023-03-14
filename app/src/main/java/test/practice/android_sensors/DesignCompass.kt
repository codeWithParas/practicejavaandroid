package test.practice.android_sensors

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import test.practice.R
import test.practice.databinding.ActivityCompassBinding

class DesignCompass : AppCompatActivity() {

    lateinit var binding: ActivityCompassBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompassBinding.inflate(layoutInflater)
        setContentView(binding.root)

        LocalBroadcastManager.getInstance(this).registerReceiver(
            broadcastReceiver,
            IntentFilter(LocatyService.KEY_ON_SENSOR_CHANGED_ACTION)
        )
    }

    override fun onResume() {
        super.onResume()
        startForegroundServiceForSensors(false)
    }

    private fun startForegroundServiceForSensors(background: Boolean) {
        val locatyIntent = Intent(this, LocatyService::class.java)
        locatyIntent.putExtra(LocatyService.KEY_BACKGROUND, background)
        ContextCompat.startForegroundService(this, locatyIntent)
    }

    override fun onPause() {
        super.onPause()
        startForegroundServiceForSensors(true)
    }

    override fun onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver)
        super.onDestroy()
    }

    private val broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val direction =
                intent.getStringExtra(LocatyService.KEY_DIRECTION)
            val angle = intent.getDoubleExtra(LocatyService.KEY_ANGLE, 0.0)
            val angleWithDirection = "$angle  $direction"
            binding.directionTextView.text = angle.toString()
            //binding.directionTextView.text = angleWithDirection
            updateUI(angle, direction)
        }
    }

    private fun updateUI(angle: Double, direction: String?) {
        println("@@@ Angle $angle $direction")

        when (direction) {
            "E" -> {
                binding.centreRightView.background =
                    ContextCompat.getDrawable(this, R.color.colorAccent)
                binding.topCentreView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.topLeftView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.rightTopView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.centreLeftView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.bottomLeftView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.bottomRightView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.bottomCentreView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
            }
            "W" -> {
                binding.centreLeftView.background =
                    ContextCompat.getDrawable(this, R.color.colorAccent)
                binding.topCentreView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.topLeftView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.rightTopView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.centreRightView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.bottomLeftView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.bottomRightView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.bottomCentreView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
            }
            "N" -> {
                binding.topCentreView.background =
                    ContextCompat.getDrawable(this, R.color.colorAccent)
                binding.topLeftView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.rightTopView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.centreRightView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.centreLeftView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.bottomLeftView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.bottomRightView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.bottomCentreView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
            }
            "S" -> {
                binding.bottomCentreView.background =
                    ContextCompat.getDrawable(this, R.color.colorAccent)
                binding.topCentreView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.topLeftView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.rightTopView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.centreRightView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.centreLeftView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.bottomLeftView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.bottomRightView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
            }
            "NE" -> {
                binding.rightTopView.background =
                    ContextCompat.getDrawable(this, R.color.colorAccent)
                binding.topCentreView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.topLeftView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.centreRightView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.centreLeftView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.bottomLeftView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.bottomRightView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.bottomCentreView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
            }
            "NW" -> {
                binding.topLeftView.background =
                    ContextCompat.getDrawable(this, R.color.colorAccent)
                binding.topCentreView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.rightTopView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.centreRightView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.centreLeftView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.bottomLeftView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.bottomRightView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.bottomCentreView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
            }
            "SE" -> {
                binding.bottomRightView.background =
                    ContextCompat.getDrawable(this, R.color.colorAccent)
                binding.topCentreView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.topLeftView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.rightTopView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.centreRightView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.centreLeftView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.bottomLeftView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.bottomCentreView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
            }
            "SW" -> {
                binding.bottomLeftView.background =
                    ContextCompat.getDrawable(this, R.color.colorAccent)
                binding.topCentreView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.topLeftView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.rightTopView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.centreRightView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.centreLeftView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.bottomRightView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.bottomCentreView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
            }
            else -> {
                binding.topCentreView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.topLeftView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.rightTopView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.centreRightView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.centreLeftView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.bottomLeftView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.bottomRightView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
                binding.bottomCentreView.background =
                    ContextCompat.getDrawable(this, R.drawable.rounded_rectangle_strip)
            }
        }
    }
}