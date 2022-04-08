package com.test.kotlinpractice.kotlin_language

class P_KotlinCoroutines {
}

//https://www.youtube.com/watch?v=eUfSmd-ntUI
//https://www.youtube.com/watch?v=ClbkwHaC0Ds

// It makes writing asynchronous code in a very simple way in Android
// Used in case of API response waiting

// Previous General Solution
// Using AsyncTask -> callback doInBackGround(){}, onPostExecute(){}
// Using RetroFit -> callback onResponse(){}, onFailure(){}

// Problem - calling multiple API request synchronously into one another i.e callback inside callback(CALLBACK HELL).
// This makes code bulky. Solution is coroutines. Retrofit also support coroutines from version 2.6.2
// Coroutine is a thread.

fun main() {

}

suspend fun fetchDataFromNetwork() {
    val result = networkAPIHit()
    updateUI(result)
}

fun updateUI(result: Boolean) {
    // Update UI
}

fun networkAPIHit(): Boolean {
    return true
}
