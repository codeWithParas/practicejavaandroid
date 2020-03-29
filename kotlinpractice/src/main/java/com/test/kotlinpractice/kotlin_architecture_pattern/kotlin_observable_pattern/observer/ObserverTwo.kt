package com.test.kotlinpractice.kotlin_architecture_pattern.kotlin_observable_pattern.observer

import com.test.kotlinpractice.kotlin_architecture_pattern.kotlin_observable_pattern.DataRepository
import com.test.kotlinpractice.kotlin_architecture_pattern.kotlin_observable_pattern.RepositoryObserver
import com.test.kotlinpractice.kotlin_architecture_pattern.kotlin_observable_pattern.SubjectActions

class ObserverTwo(dataRepository: SubjectActions) : RepositoryObserver, MainObserver("Observer Two"){

    init {
        dataRepository.registerObserver(this)
    }

    override fun onDataSetChanged() {
        println("Observer Two Notified")
    }

}