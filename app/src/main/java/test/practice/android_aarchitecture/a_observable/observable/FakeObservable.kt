package test.practice.android_aarchitecture.a_observable.observable

import test.practice.android_aarchitecture.a_observable.datarepo.DataRepository

class FakeObservable(var dataRepository: DataRepository) : Thread()
{
    // API incoming data
    var count : Int = 0
    override fun run() {
        while (count < 10)
        {
            count++
            sleep(2000)
            dataRepository.updateData("Data is changing $count")
        }
    }

}