package com.test.kotlinpractice.kotlin_language


class II_KotlinCompanionObject {
}

// Uses of companion object : https://www.youtube.com/watch?v=Dt8zTBdDv5w
// 1. Property needed at class level and not a specific instance
//  member variable : each object has its own copy
//  class variable : one variable shared among all objects (companion object)
// 2. Factory Pattern : perform extra work before an object can be used

fun main() {
    println(BankAccount.TAG)
    /*repeat(4){
        //println(BankAccount("Paras$it"))
        println(BankAccount.create("Paras$it"))
    }

    Thread().run {
        println(this.name)
        println(BankAccount.create("Paras$1"))
        println(BankAccount.nextId)
    }

    Thread().run {
        println(this.name)
        println(BankAccount.nextId)
    }*/

    /////////////

    repeat(4) {
        //println(BankAccount("Paras$it"))
        println(BankAccountOld("Paras$it"))
    }

    Thread().run {
        println(this.name)
        println(BankAccountOld("Paras$1"))
        println(BankAccountOld.nextId)
    }

    Thread().run {
        println(this.name)
        println(BankAccountOld("Paras$1"))
        println(BankAccountOld.nextId)
    }
}

// private constructor : just to make validation before anyone try to use any bank account
// to solve we can create function to create object of Bank Account after validation
class BankAccount private constructor(private val name: String) {

    companion object {
        const val TAG = "BankAccount"
        var nextId = 0
        fun create(name: String): BankAccount? {
            val instance = BankAccount(name)
            return if (instance.validateIdentity()) instance else null
        }
    }

    private val user0: String = "Paras0"
    fun validateIdentity(): Boolean {
        // validate user account
        return user0 == name
    }

    private var accountId: Int = 0

    init {
        accountId = nextId++
    }

    override fun toString(): String {
        return "$TAG id $accountId with name $name"
    }
}

class BankAccountOld(private val name: String) {

    companion object {
        const val TAG = "BankAccount"
        var nextId = 0
    }

    private var accountId: Int = 0

    init {
        accountId = nextId++
    }

    override fun toString(): String {
        return "$TAG id $accountId with name $name"
    }
}