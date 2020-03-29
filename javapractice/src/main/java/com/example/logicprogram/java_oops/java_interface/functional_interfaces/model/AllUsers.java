package com.example.logicprogram.java_oops.java_interface.functional_interfaces.model;

import java.util.ArrayList;

public class AllUsers {

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    private ArrayList<User> users;
}
