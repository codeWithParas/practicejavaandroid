package com.example.logicprogram.design_pattern.c_behavioral_pattern.x_observable_pattern;

public interface Subject {

    void registerObserver(RepositoryObserver repositoryObserver);
    void removeObserver(RepositoryObserver repositoryObserver);
    void notifyObservers();
    void setDataFromObservable(String str);
}
