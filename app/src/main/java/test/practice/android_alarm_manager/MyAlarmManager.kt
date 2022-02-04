package test.practice.android_alarm_manager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent

object MyAlarmManager {

    private var pendingIntent: PendingIntent? = null

    fun setAlarm(context: Context, alarmTime: Long, message: String) {
        val alarmManager: AlarmManager =
            context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val intent = Intent(context, MyIntentService::class.java)
        intent.action = MyIntentService.ACTION_SEND_TEST_MESSAGE
        intent.putExtra(MyIntentService.EXTRA_MESSAGE, message)

        //val intent = Intent(context, MyBroadcastReceiver::class.java)
        pendingIntent =
            PendingIntent.getService(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        //alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, alarmTime, pendingIntent)
        val interval: Long = 5000
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, alarmTime, interval, pendingIntent)
        //alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() , interval, pendingIntent)
        //alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,  interval, pendingIntent)
    }

    fun cancelAlarm(context: Context) {
        pendingIntent?.let {
            val alarmManager: AlarmManager =
                context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.cancel(it)
        }
    }

}