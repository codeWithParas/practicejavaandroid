package com.test.kotlinpractice.kotlin_architecture_pattern.kotlin_observable_pattern

interface SubjectActions {
    fun updateData()
    fun registerObserver(observer : RepositoryObserver)
    fun notifyObserever()
}