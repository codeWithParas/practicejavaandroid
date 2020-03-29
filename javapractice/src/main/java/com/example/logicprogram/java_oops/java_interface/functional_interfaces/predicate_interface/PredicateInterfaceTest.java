package com.example.logicprogram.java_oops.java_interface.functional_interfaces.predicate_interface;

import com.example.logicprogram.java_oops.java_interface.functional_interfaces.model.AllUsers;
import com.example.logicprogram.java_oops.java_interface.functional_interfaces.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateInterfaceTest {

    private static AllUsers allUsers;

    public static void main(String[] args) {

        createUsers();
        if(allUsers == null)
            return;

        ArrayList<User> users = allUsers.getUsers();

        /*
        * Predicate Interface use : This case b boolean : test() method will return true if User is not active.
        * So remove all the users who are not active.
        * */
        /*boolean b = users.removeIf(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return !user.isActive();
            }
        });*/

        //using lambdas
        /*users.removeIf(user -> {
            return !user.isActive();
        });*/

        users.removeIf(user -> !user.isActive());

        /*
        * Consumer Interface test
        * */

        Consumer<User> consumer = new Consumer<User>() {
            @Override
            public void accept(User user) {
                calculateTax(user);
            }

            private void calculateTax(User user) {

            }
        };

        users.stream().forEach(user -> {
            //demo method
            calculateTax();
        });

        for (User user : users) {
            System.out.println(user.name);
        }
    }

    private static void calculateTax() {

    }

    private static void createUsers() {

        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1,"User1",true));
        users.add(new User(2,"User2",false));
        users.add(new User(3,"User3",true));
        users.add(new User(4,"User4",false));
        users.add(new User(5,"User5",true));
        users.add(new User(6,"User6",false));
        users.add(new User(7,"User7",true));
        users.add(new User(8,"User8",false));
        users.add(new User(9,"User9",true));
        users.add(new User(10,"User10",false));

        allUsers = new AllUsers();
        allUsers.setUsers(users);
    }

}
