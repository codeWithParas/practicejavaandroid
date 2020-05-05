package test.practice.android_aarchitecture.a_observable.datarepo

import test.practice.android_aarchitecture.a_observable.action.SubjectDataAction
import test.practice.android_aarchitecture.a_observable.observer.RepositoryObserver

class DataRepository(val repoName: String, val repoId : Int) : SubjectDataAction
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

    override fun loadData() {
        TODO("Not yet implemented")
    }

    override fun updateData(dataFromAPI: String) {
        println("Data has been updated.")
        notifyObserver(dataFromAPI)
    }

    override fun registerObserver(observer : RepositoryObserver) {
        if(!observers.contains(observer))
        {
            println("Observer is Registered Successfully !")
            observers.add(observer)
        }
    }

    override fun notifyObserver(dataChange: String) {
        for (observer in observers) {
            observer.setDataChange(dataChange)
        }
    }
}