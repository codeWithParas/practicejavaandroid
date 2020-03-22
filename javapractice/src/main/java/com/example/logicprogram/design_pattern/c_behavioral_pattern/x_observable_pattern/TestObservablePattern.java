package com.example.logicprogram.design_pattern.c_behavioral_pattern.x_observable_pattern;

public class TestObservablePattern{

    /*
    * Link : https://www.baeldung.com/java-observer-pattern
    * Observer is a behavioral design pattern.
    * >> It specifies communication between objects: observable and observers.
    * >> An observable is an object which notifies observers about the changes in its state.
    *
    * Understanding : In our setup example we are notifying every observer in the system at each iteration.
    * Refer Img and following points :
    * Link : https://classroom.udacity.com/courses/ud9012/lessons/da3967cc-ba85-4045-bb46-dea1c770fb8b/concepts/cf12397d-82fb-4e17-875c-0853f24f902b
    * 1) In Observer Pattern where you have an Object called an "SUBJECT".
    * 2) The Subject keeps track of list of other objects called as "OBSERVER".
    * 3) "OBSERVERS" watch the subject.
    * 4) When the status of the "SUBJECT" changes. The "SUBJECT" will notify "OBSERVERS" by calling a method in the "OBSERVER".
    *
    * In Android (MVVM-LiveData) : The "SUBJECT" is the LiveData object. Refer Example  : LearnKotlin Project
    * */

    private static Subject mModelRepository;

    public static void main(String args[])
    {
        System.out.println("\n\n>>>>>>>>>>>>>>> Initializing Observable >>>>>>>>>>>> ");
        mModelRepository = ModelRepository.getInstance();
        Observable startObservable = new Observable();

        System.out.println(">>>>>>>>>>>>>>> Registering all observers >>>>>>>>>>>>> ");
        new ObserverOne();
        new ObserverTwo();
        new ObserverThree();

        System.out.println("\n\n>>>>>>>>>>>>>>> Starting Observable >>>>>>>>>>>> ");
        startObservable.start();
    }

    static class Observable extends Thread
    {
        public void run()
        {
            for (int i = 1; i <= 3; i++)
            {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                mModelRepository.setDataFromObservable("Observers Notification Trial No. : " + i);
            }
        }
    }

    static class ObserverOne implements RepositoryObserver
    {
        public ObserverOne()
        {
            System.out.println("ObserverOne is Registered");
            mModelRepository.registerObserver(this);
        }

        @Override
        public void onUserDataChanged(String data) {

            System.out.println("Data Notified at ObserverOne  " + data);
        }
    }

    static class ObserverTwo implements RepositoryObserver
    {
        public ObserverTwo()
        {
            System.out.println("ObserverTwo is Registered");
            mModelRepository.registerObserver(this);
        }

        @Override
        public void onUserDataChanged(String data) {

            System.out.println("Data Notified at ObserverTwo  " + data);
        }
    }

    static class ObserverThree implements RepositoryObserver
    {
        public ObserverThree()
        {
            System.out.println("ObserverThree is Registered");
            mModelRepository.registerObserver(this);
        }

        @Override
        public void onUserDataChanged(String data) {

            System.out.println("Data Notified at ObserverThree  " + data);
        }
    }
}
