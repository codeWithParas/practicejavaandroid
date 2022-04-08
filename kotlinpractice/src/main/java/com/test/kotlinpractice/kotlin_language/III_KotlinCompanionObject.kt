package com.test.kotlinpractice.kotlin_language

class III_KotlinCompanionObject {
}

// https://www.youtube.com/watch?v=Vuwa21Xy-dc

class Manager1 private constructor() {

    companion object {
        private var instance: Manager1? = null

        //fun getInstance() { //not thread safe
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
    // println(Manager.getInstance())
    println(Manager)

    Thread().run {
        // println(Manager.getInstance())
        println(Manager)
    }
}