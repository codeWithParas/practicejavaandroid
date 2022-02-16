package test.practice.android_aaa_kotlin_rxjava.rx_observable_example

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import test.practice.android_aaa_kotlin_rxjava.common.disposedBy

object TraitsRx {

    // Traits :  These are task that can be rapped in a single observable.
    // 3 Types : Single , Completable , Maybe   ~~~~(All are observables)
    // Mostly used during network calls.

    // Single receives (onNext, onError)
    // Completable receives (onComplete, onError)
    // Maybe receives (onNext/onComplete, onError)


    var bag = CompositeDisposable()

    fun traits_single() {
        val single = Single.create<String> { single ->
            //do some logic here
            val success = true


            if (success) {
                //return a value // some sort of data coming from network request
                single.onSuccess("nice work!")
            } else {
                val someException = IllegalArgumentException("some fake error")
                single.onError(someException)
            }
        }

        single.subscribe({ result ->
            //do something with result
            println("👻 single: ${result}")
        }, { error ->
            //do something for error
        }).disposedBy(bag)
    }


    fun traits_completable() {

        //Example : Do completable when you are going to do "POST" request and there is no result coming back other than a success code 200 or some failure.
        val completable = Completable.create { completable ->
            //do logic here
            val success = true

            if (success) {
                completable.onComplete()
            } else {
                val someException = IllegalArgumentException("some fake error")
                completable.onError(someException)
            }
        }

        completable.subscribe({
            //handle on complete
            println("👻 Completable completed")
        }, { error ->
            //do something for error
        }).disposedBy(bag)

    }

    fun traits_maybe() {

        // can have 3 states : 1) success 2) complete 3) error

        val maybe = Maybe.create<String> { maybe ->
            //do something like API call : got below result
            val success = true   // success contain 2 state : someResult or completable
            val hasResult = true


            if (success) {
                if (hasResult) {
                    maybe.onSuccess("some result")
                } else {
                    maybe.onComplete()
                }
            } else {
                val someException = IllegalArgumentException("some fake error")
                maybe.onError(someException)
            }
        }

        maybe.subscribe({ result ->
            //do something with result
            println("👻 Maybe - result: ${result}")
        }, { error ->
            //do something with the error
        }, {
            //do something about completing
            println("👻 Maybe - completed")
        }).disposedBy(bag)
    }
}