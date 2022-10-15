package com.test.kotlinpractice.kotlin_language.kotlin_basics

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

class Q_KotlinCoroutines {
}

//https://www.youtube.com/watch?v=icShqRqEQgA&list=PLRKyZvuMYSIN-P6oJDEu3zGLl5UQNvx9y&index=3

// Coroutines = scope + context + dispatchers (Threads on which coroutines are executed.)
// Dispatchers :
// 1) Dispatcher.IO
// 2) Dispatcher.MAIN
// 3) Dispatcher.DEFAULT
// Coroutines made up of suspending functions.
// Important : Coroutines helps to implement functionality that can be suspended and later resumed at specific point without blocking the thread.

suspend fun main() {
    //Check execution in app
    CoroutineScope(Dispatchers.Default).launch {
        println("S ${Thread.currentThread().name}")
        task1()
    }

    task1()
}

suspend fun task1() {
    println("Start ${Thread.currentThread().name}")
    yield()
    println("End ${Thread.currentThread().name}")
}