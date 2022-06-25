package com.test.kotlinpractice.kotlin_language.kotlin_basics

class III_KotlinCompanionObject {
}

// https://www.youtube.com/watch?v=Vuwa21Xy-dc

// Operator Invoke Functionality
// Companion Object

class Manager1 private constructor() {

    companion object {
        private var instance: Manager1? = null

        // fun getInstance() { //not thread safe
        // fun getInstance() = synchronized(this) {
        operator fun invoke() = synchronized(this) {  // using invoke() operator
            if (instance == null)
                instance = Manager1()
            instance
        }
    }
}

// Above singleton class can be replaced with object

object Manager {
    init {
        println("Manager object created")
    }
}


fun main() {
    // Manager1.getInstance()
    // Manager1()
    // println(Manager.getInstance())

    // We always have same instance of Manager
    println(Manager)
    Thread().run {
        // println(Manager.getInstance())
        println(Manager)
    }
}