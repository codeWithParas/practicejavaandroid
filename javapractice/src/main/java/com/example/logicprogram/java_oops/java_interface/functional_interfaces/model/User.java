package com.example.logicprogram.java_oops.java_interface.functional_interfaces.model;

public class User {

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
    }
}
