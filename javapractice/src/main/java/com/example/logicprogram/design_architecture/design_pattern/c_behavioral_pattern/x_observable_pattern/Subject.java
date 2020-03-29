package com.example.logicprogram.design_architecture.design_pattern.c_behavioral_pattern.x_observable_pattern;

public interface Subject {

    /*
    * This is Subject Action Interface that implements actions on data.
    * Like : setData, registerObserver, notifyObserver
    * */

    void registerObserver(RepositoryObserver repositoryObserver);
    void removeObserver(RepositoryObserver repositoryObserver);
    void notifyObservers();
    void setDataFromObservable(String str);
}
