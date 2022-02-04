package test.practice.android_alarm_manager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_test_alarm_manager.*
import test.practice.R
import java.util.*

class TestAlarmManager : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_alarm_manager)

        val calendar = Calendar.getInstance()
        calendar.add(Calendar.SECOND, 5)

        start.setOnClickListener {

            //val i: Int = editText.getText().toString().toInt()
            MyAlarmManager.setAlarm(applicationContext, calendar.timeInMillis, "Paras!")
        }

        stop.setOnClickListener {

            MyAlarmManager.cancelAlarm(applicationContext)
        }
    }
}