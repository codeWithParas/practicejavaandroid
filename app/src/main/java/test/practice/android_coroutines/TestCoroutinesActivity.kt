package test.practice.android_coroutines

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import test.practice.R

class TestCoroutinesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        * Test API
        * */
        setContentView(R.layout.activity_quote_binding)

        /*
        * Test Coroutines
        * */

        /*setContentView(R.layout.activity_a)

        CoroutineScope(Dispatchers.Main).launch {
            callAPI()
        }

        CoroutineScope(Dispatchers.Main).launch {
            updateUI()
        }*/
    }
}

suspend fun callAPI() {
    println("Start API ${Thread.currentThread().name}")
    // yield()    // suspending point
    delay(2000)    // suspending point
    println("End API ${Thread.currentThread().name}")
}

suspend fun updateUI() {
    println("Start Update UI ${Thread.currentThread().name}")
    //yield()
    delay(2000)
    println("End UI updated ${Thread.currentThread().name}")
}