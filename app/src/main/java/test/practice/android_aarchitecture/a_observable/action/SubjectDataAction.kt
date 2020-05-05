package test.practice.android_aarchitecture.a_observable.action

import test.practice.android_aarchitecture.a_observable.observer.RepositoryObserver

interface SubjectDataAction {

    fun loadData()
    fun updateData(dataFromAPI : String)

    //subscribeView() => registerObserver => add into list of observers
    fun registerObserver(observer : RepositoryObserver)

    fun notifyObserver(dataChange : String)
}