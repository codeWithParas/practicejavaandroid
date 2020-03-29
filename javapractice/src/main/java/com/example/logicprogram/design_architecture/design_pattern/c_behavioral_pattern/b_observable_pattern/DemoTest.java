package com.example.logicprogram.design_architecture.design_pattern.c_behavioral_pattern.b_observable_pattern;


/*
 *
 * Imp : Inform the subscriber(through observer) if anything is changed in data(observable).
 *
 * We need to be informed when certain things happen like :
 * -> Object field changes
 * -> object does something
 * -> some event occur
 *
 * So we want to listen to events and notified when they occur
 *
 * Observer : is an object that wishes to be informed about events happening
 * in the system. The entity generating the events is an
 * Observable.
 *
 *
 * ---------------------------------------
 * Now what we want to be able to achieve is we want to be able to get change
 * notifications whenever somebody sets the age.
 * You might have some UI component that needs to be informed about the fact that the age(property) has been said
 * and we're going to try building some infrastructure in order to support this idea of probably change
 * notification effectively.
 * --------------------------------------
 * //PropertyChangedEventArgs<T>
 * OK so the first thing I'm going to do is make a class called Probably the change event arcs.
 * So this is going to contain some information about changes to a particular property and this is going
 * to be on objects of type TTYs in our case is a person but it can be virtually anything.
 *
 * >>>>>>so here we basically take care of properties that is going to be changed by observable.
 * So we need observer and observable now------>
 *
 * ---------------------------------------
 *
 * //interface Observer<T>
 *
 * Observer :
 * So let's start with observers so observer is the interface that you'd expect to implement to be implemented
 * by anyone interested in observing an object of type T. So having the interface called observer of T and this
 * interface is going to have just a single method called handle which is going to take precisely this probably
 * changed event auks thing that we've just constructed.
 * So essentially the idea is that if you want to monitor an object of type T then you implement the observer off t interface.
 * You define your own handle method and then hope that that handle method will be executed whenever somebody
 * actually perform some changes.
 * Now we need the observable part.
 *
 * -------------------------------------
 *
 * So Observer is thing that looking at something and Observable is the object who you can actually look at.
 *
 * Observable : So we have the observer the observer is the thing that's looking at something and the observable is
 * the object who you can actually look at.
 * So here I'm going to make it class. So instead of an interface I have a concrete class called observable of T and this class
 * is going to have a list of all the people all the subscribers that are watching a particular class so.
 *
 *
 * OBSERVABLE ----------------> The data object that is going to be changed.
 * OBSERVER ------------------> Consider a Kind of UI component that will going to know when any data changes.
 *
 * //method : protected void propertyChanged()
 * Now in addition what we want to do obviously is we want to notify on the changes so whoever inherits
 * from observable if team needs to fire some method to actually notify every observer that something has happened.
 *
 *
 * ----------------------------------------------------
 *
 * In Brief*** : Observable entity is going to be changed , it will get registered in the observable repo, on every change
 * in the property of any observable entity, the observer (interface) will be responsible to notify that change on the
 * front (UI);
 *
 *
 *
 * */

import java.util.ArrayList;



interface Observer<T>
{
    void handle(PropertyChangedEventArgs<T> args);
}

/*Observer : Observes the changes*/
public class DemoTest
{
    public static void main(String[] args)
    {
        new DemoTest();
    }

    public DemoTest()
    {
        new PersonObserver();
        new AlienObserver();
    }

    /*
     * Can be implemented by fragments (observer)
     * */
    class PersonObserver implements Observer<Person> {

        PersonObserver()
        {
            Person person = new Person();
            person.subscribe(this);
            // remote data via retrofit call-> use ViewModel(Observable) object in this fragment to call api
            // use ViewModel to update the data in model person
            person.setAge(23);
        }

        @Override
        public void handle(PropertyChangedEventArgs<Person> args) {
            System.out.println("Person's " + args.proprtyName + " has change to " + args.newValue);
        }
    }

    class AlienObserver implements Observer<Alien> {

        AlienObserver(){
            Alien a = new Alien();
            a.subscribe(this);
            a.setAge(22);
        }

        @Override
        public void handle(PropertyChangedEventArgs<Alien> args) {
            System.out.println("Alien's " + args.proprtyName + " has change to " + args.newValue);
        }
    }
}


class PropertyChangedEventArgs<T>
{
    public T source;
    public String proprtyName;
    public Object newValue;

    public PropertyChangedEventArgs(T source, String propertyName, Object newValue)
    {
        //boxing
        this.source = source;
        this.proprtyName = propertyName;
        this.newValue = newValue;
    }
}

class Observable<T>
{
    ArrayList<Observer<T>> observers = new ArrayList<>();

    public void subscribe(Observer<T> observer)
    {
        observers.add(observer);
    }

    protected void propertyChanged(T source, String propertyName, Object newValue)
    {
        for (Observer<T> o : observers)
        {
            o.handle(new PropertyChangedEventArgs<T>(source, propertyName, newValue));
        }
    }
}

/*Observable : Change the data or property*/
//Data class Person : age is its property
class Person extends Observable<Person>
{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        if(this.age == age) return;
        this.age = age;
        propertyChanged(this, "age", age);
    }
}

//Data class Alien : age is its property
class Alien extends Observable<Alien>
{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        if(this.age == age) return;
        this.age = age;
        propertyChanged(this, "age", age);
    }
}
