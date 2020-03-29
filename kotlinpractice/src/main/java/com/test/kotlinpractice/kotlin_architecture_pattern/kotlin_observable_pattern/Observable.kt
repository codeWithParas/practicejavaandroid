package com.test.kotlinpractice.kotlin_architecture_pattern.kotlin_observable_pattern

import com.test.kotlinpractice.kotlin_architecture_pattern.kotlin_observable_pattern.observer.ObserverOne
import com.test.kotlinpractice.kotlin_architecture_pattern.kotlin_observable_pattern.observer.ObserverTwo


fun main()
{
    //init repositroy
    val dataRepository : SubjectActions = DataRepository("Myrepo", 1).getInstance()
    //register observers
    ObserverOne(dataRepository)
    ObserverTwo(dataRepository)

    //start observable and update data
    Observable(dataRepository).start()
}

class Observable(var dataRepository: SubjectActions) : Thread(){
    override fun run() {
        for (i in 0 until 3)
        {
            sleep(3000)
            dataRepository.updateData()
        }
    }
}