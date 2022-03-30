package test.practice.android_aaa_kotlin_rxjava.rx_observable_example

import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.toObservable
import io.reactivex.subjects.BehaviorSubject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import test.practice.android_aaa_kotlin_rxjava.common.disposedBy
import java.util.concurrent.TimeUnit

object SimpleRx {
    //Observables Types : Relay, Subject, Observables
    //CompositeDisposable : Its a container from which we get bunch of disposable.
    //disposable : when we create a subscription will given a something like a pointer to that subscription.
    // So that when the life of this class dies we can cleanup all the subscription contained in that(composite disposal).
    private val bag = CompositeDisposable()

    fun relayExample() {
        //BEHAVIOR RELAY : Relay will never receive onError, onComplete event.
        // Called hot observables. Trigger the most new update.
        //Behavior relay Imperative nature : We set the value and get the value anytime we want.
        /**
         * Relay that emits the most recent item it has observed and all subsequent observed items to each subscribed
         * src="https://raw.github.com/wiki/ReactiveX/RxJava/images/rx-operators/S.BehaviorSubject.png"

        // observer will receive all events.
        BehaviorRelay<Object> subject = BehaviorRelay.create("default");
        subject.subscribe(observer);
        subject.accept("one");
        subject.accept("two");
        subject.accept("three");

        // observer will receive the "one", "two" and "three" events, but not "zero"
        BehaviorRelay<Object> subject = BehaviorRelay.create("default");
        subject.accept("zero");
        subject.accept("one");
        subject.subscribe(observer);
        subject.accept("two");
        subject.accept("three");
        } </pre>
         */
        println("~~~~~~Behavior relay Imperative nature~~~~~~")
        val behaviorRelay = BehaviorRelay.createDefault("1")
        println("Some Values : ${behaviorRelay.value}")
        behaviorRelay.accept("2")
        behaviorRelay.accept("3")
        println("someInfo.value : ${behaviorRelay.value}")


        //Declarative nature of Behavior Relay : We tell RxJava what we want to see but we wont tell how to get it.

        println("~~~~~~Behavior relay Declarative nature~~~~~~")

        val behaviorRelayObj = behaviorRelay.subscribe { newValue ->
            println(" Got New Value -> Most Recent Will Be Taken By BehaviorRelay : $newValue")

        }

        behaviorRelay.accept("4")
        behaviorRelayObj.disposedBy(bag)
        //The number of element we get that were created before we subscribed.

    }

    fun subjectExample() {

        //BEHAVIOR SUBJECT
        // These can be subscribers and observers meaning you combine the o/p of one observable and make it another i/p.
        // Also known as hot observables : depend on types
        // 3 types :  Behavior, Publish, Replay : they all deal with number of previous events the subscriber receives.
        // Behavior : receives last event or default value.
        // Publish : Only get new events.
        // Replay : n number of previous buffer events
        // ~~~~~~~~ let subject = ReplaySubject<String>.create(bufferSize: 3)

        println("~~~~~~Behavior Subject~~~~~~")

        val behaviorSubject = BehaviorSubject.createDefault(24)

        val subDisposable = behaviorSubject.subscribe({ newValue -> //onNext
            println(" Behavior Subject Subscribed : $newValue")
        }, { error -> //Error
            println(" onError : ${error.localizedMessage}")
        }, { //onComplete
            println(" onCompleted")
        }, { _ -> //onSubscribed
            println(" subscribed")
        })

        behaviorSubject.onNext(26)
        behaviorSubject.onNext(48)
        behaviorSubject.onNext(48) //duplicates show as new events by default.

        // 1) onError : When some exception thrown then after that this will not work.
        var exception = IllegalArgumentException("Some Fake Error")
        //behaviorSubject.onError(exception)
        behaviorSubject.onNext(50) // this will never show after error thrown

        // 2) onComplete :
        behaviorSubject.onComplete()
        behaviorSubject.onNext(60) // this will never show

    }

    fun observableExample() {
        //Observables :  Normally we consume them but sometimes we need to create them for lil level stuffs like network, database, fileIO or anything that is long running and
        // you want to know when the task is going to end that's when you going to use Observables.
        // Used in the case for chaining different network calls.

        //The Observable
        val observable = Observable.create<String> { observer ->

            // THIS LAMBDA WILL BE CALLED FOR EVERY SUBSCRIBER
            println("~~~~~~Observable~~~~~~")

            //Do a work on background thread.
            GlobalScope.launch(Dispatchers.IO) {
                //mutating long running operation : ARTIFICIAL DELAY
                println("Current Thread Name : " + Thread.currentThread().name)
                observer.onNext("Some Value 10")
                //delay(8000)
                yield()
                println("Current Thread Name : " + Thread.currentThread().name)
                observer.onNext("Some Value 20")
                observer.onComplete()
            }
        }

        observable.subscribe { someString ->
            println(" First Subscriber Some data : $someString")
        }.disposedBy(bag)

        val anotherObserver = observable.subscribe { someString ->
            println(" Another Subscriber data : $someString")
        }
        anotherObserver.disposedBy(bag)

    }

    fun otherExamplesOfObservable() {
        //1) using some generic containers
        val observable1 = Observable.just("Some Name")      //observable of one event
        val observable2 = Observable.just(2)
        val subscribe = observable2.subscribe { data ->
            println(" Another Subscriber data : $data")
        }

        //2) using timer - stop on count 10
        val observable = Observable.interval(3, TimeUnit.SECONDS)
            .timeInterval(AndroidSchedulers.mainThread())   //mainThread : ensures to run on main thread
        val observer = observable.subscribe {
            println("Time Interval Example ${it.value()}")
            //Stop on some count
            if (it.value().toInt() == 10) {
                bag.dispose()
            }
        }
        observer.disposedBy(bag)

        //3) using array observables
        val userIds = arrayOf(1, 2, 3, 4, 5)
        //val observable = Observable.fromArray(*userIds)
        val arrayObservable = userIds.toObservable()
        arrayObservable.subscribe {
            println(it)
        }


    }
}