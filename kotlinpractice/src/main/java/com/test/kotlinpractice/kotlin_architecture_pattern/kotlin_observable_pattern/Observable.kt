package com.test.kotlinpractice.kotlin_architecture_pattern.kotlin_observable_pattern

import com.test.kotlinpractice.kotlin_architecture_pattern.kotlin_observable_pattern.observer.ObserverOne
import com.test.kotlinpractice.kotlin_architecture_pattern.kotlin_observable_pattern.observer.ObserverTwo

// IMPORTANT Before starting : Please learn this first. This example designed and needs to be watched before learning any other example related to Observable-Subscriber Pattern.
// Assume here the main method is like a compiler in android that allocate memory for all variables and classes(activity/fragments)
// Main thread here acting like a installer for app.

fun main() {
    //init repository
    val dataRepository: SubjectActions = DataRepository("Myrepo", 1).getInstance()
    //register observers
    ObserverOne(dataRepository)
    ObserverTwo(dataRepository)

    //start observable and update data
    //Assume this is like we are starting a application
    Observable(dataRepository).start()
}


/**
 * Thread : Assume this is like a Android main thread (onAttach() inside presenter).
 *
 * Observable : An Entity (Network Call/ Data Repo) that gives data change intimation to the observer.
 * Observable : An Entity (Network Call/ Data Repo) that can be observed by observer.
 * Example : Data Change due to async network call at any time happen in future.
 * This should be automatically get notifies on view layer.
 */
class Observable(var dataRepository: SubjectActions) : Thread() {
    override fun run() {
        //Assume hitting API 3 times and updating UI
        for (i in 0 until 3) {
            sleep(3000)
            dataRepository.updateData()
        }
    }
}