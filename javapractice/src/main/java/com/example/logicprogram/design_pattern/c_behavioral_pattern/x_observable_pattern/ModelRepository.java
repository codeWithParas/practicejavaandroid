package com.example.logicprogram.design_pattern.c_behavioral_pattern.x_observable_pattern;

import java.util.ArrayList;

public class ModelRepository implements Subject{

    private String data;
    private String type;

    private static ModelRepository INSTANCE = null;
    private final ArrayList<RepositoryObserver> mObservers;
    private RepositoryObserver repositoryObserver;

    private ModelRepository() {
        mObservers = new ArrayList<>();
    }

    public static ModelRepository getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ModelRepository();
        }
        return INSTANCE;
    }

    @Override
    public void registerObserver(RepositoryObserver repositoryObserver) {
        this.repositoryObserver=repositoryObserver;
        if(!mObservers.contains(repositoryObserver)) {
            mObservers.add(repositoryObserver);
        }
    }

    @Override
    public void removeObserver(RepositoryObserver repositoryObserver) {
        if(mObservers.contains(repositoryObserver)) {
            mObservers.remove(repositoryObserver);
        }
    }

    @Override
    public void notifyObservers() {
        for (RepositoryObserver observer: mObservers) {
            observer.onUserDataChanged(data);
        }
    }

    @Override
    public void setDataFromObservable(String str) {
        this.data = str;
        notifyObservers();
    }
}
