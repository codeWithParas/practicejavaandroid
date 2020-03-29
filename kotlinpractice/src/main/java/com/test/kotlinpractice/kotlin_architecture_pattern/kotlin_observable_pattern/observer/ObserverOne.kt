package com.test.kotlinpractice.kotlin_architecture_pattern.kotlin_observable_pattern.observer

import com.test.kotlinpractice.kotlin_architecture_pattern.kotlin_observable_pattern.DataRepository
import com.test.kotlinpractice.kotlin_architecture_pattern.kotlin_observable_pattern.RepositoryObserver
import com.test.kotlinpractice.kotlin_architecture_pattern.kotlin_observable_pattern.SubjectActions

class ObserverOne(dataRepository: SubjectActions) : RepositoryObserver, MainObserver("Observer One") {
    init {
        dataRepository.registerObserver(this)
    }

    override fun onDataSetChanged() {

        println("Observer One Notified")

    }

}