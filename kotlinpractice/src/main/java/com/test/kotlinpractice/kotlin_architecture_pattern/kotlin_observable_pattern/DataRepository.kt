package com.test.kotlinpractice.kotlin_architecture_pattern.kotlin_observable_pattern


class DataRepository(var name : String, var id : Int) : SubjectActions
{
    private var INSTANCE: DataRepository? = null
    var observers = mutableListOf<RepositoryObserver>()
    fun getInstance() : DataRepository
    {
        if (INSTANCE == null) {
            INSTANCE = DataRepository("MyRepo", 1)
        }
        return INSTANCE as DataRepository
    }

    override fun updateData() {
        println("Data has been updated.")
        notifyObserever()
    }

    override fun registerObserver(observer : RepositoryObserver) {
        if(!observers.contains(observer))
        {
            println("Observer is Registered Successfully !")
            observers.add(observer)
        }
    }

    override fun notifyObserever() {
        // Run on main UI thread to update UI
        for (observer in observers) {
            observer.onDataSetChanged()
        }
    }

}