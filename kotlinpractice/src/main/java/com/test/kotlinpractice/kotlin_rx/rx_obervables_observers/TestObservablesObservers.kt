package com.test.kotlinpractice.kotlin_rx.rx_obervables_observers

import com.test.kotlinpractice.kotlin_rx.data_class.createTaskModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers


fun main() {

    val list = createTaskModel()
    val taskObservable = Observable
        .fromIterable(list)
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.io())
    taskObservable.subscribe({
        println("Second Thread Name : " + Thread.currentThread().name)
    }, {

    }, {

    }
    )
}

