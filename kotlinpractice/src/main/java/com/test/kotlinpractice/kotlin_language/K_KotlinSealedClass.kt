package com.test.kotlinpractice.kotlin_language

class K_KotlinSealedClass {
}

// https://www.youtube.com/watch?v=Gk2Z5zthdkw

// Sealed Class : It is used to define a limited set of values.
// Used specially in the case when data received from API response.

sealed class Data {
    data class Success(val data: String) : Data()
    data class Failed(val error: String) : Data()
    object Loading : Data()
}

fun getAPIData(): Data {
    return Data.Success((100..200).random().toString())
    //return Data.Failed((100..200).random().toString())
    //return Data.Loading
}

fun main() {
    val data = getAPIData()
    when (data) {
        is Data.Success -> {
            println(data)
        }
        is Data.Failed -> {
            println(data)
        }
        is Data.Loading -> {
            println(data)
        }
    }
}