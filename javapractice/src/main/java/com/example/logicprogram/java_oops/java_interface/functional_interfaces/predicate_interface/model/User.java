package com.example.logicprogram.java_oops.java_interface.functional_interfaces.predicate_interface.model;

public class User {

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int balance;

    public String name;
    private boolean active;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int id;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User(int id, String name, boolean isActive)
    {
        this.id = id;
        this.name = name;
        this.active = isActive;
        this.balance = 100;
    }
}
