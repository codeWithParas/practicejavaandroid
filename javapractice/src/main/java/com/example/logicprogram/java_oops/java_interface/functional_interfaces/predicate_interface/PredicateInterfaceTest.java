package com.example.logicprogram.java_oops.java_interface.functional_interfaces.predicate_interface;

import com.example.logicprogram.java_oops.java_interface.functional_interfaces.predicate_interface.model.AllUsers;
import com.example.logicprogram.java_oops.java_interface.functional_interfaces.predicate_interface.model.User;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateInterfaceTest {

    private static AllUsers allUsers;

    public static void main(String[] args) {

        /*
        * Question : Calculate tax of active users.
        * Solution : Create Users
        *           -> Filter Active Users Using : Predicate Interface
        *           -> Calculate Tax Of Users Using : Consumer Interface
        *           -> Check user is active using :  Function Interface
        *           -> Add balance of first two users using : BinaryOperator Interface
        *
        * */

        createUsers();
        if(allUsers == null)
            return;

        ArrayList<User> users = allUsers.getUsers();

        /*
        * 1) Predicate Interface use : This case b boolean : test() method will return true if User is not active.
        * So remove all the users who are not active.
        * */
        boolean b = users.removeIf(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                // return the true state to remove from list of users.
                return !user.isActive();
            }
        });
        //using lambdas
        /*users.removeIf(user -> {
            return !user.isActive();
        });*/

        //users.removeIf(user -> !user.isActive());

        /*
        * 2) Consumer Interface test
        * */

        Consumer<User> consumer = new Consumer<User>() {
            @Override
            public void accept(User user) {
                calculateTax(user);
            }

            private void calculateTax(User user) {
            }
        };

        /*
         * 3) Function Interface test : Function<InputTpe, OutputType>
         * */
        Function<User, Boolean> givesBoolean = user -> user.isActive();

        users.stream().forEach(user -> {
            //demo method
            consumer.accept(user);
            Boolean isActive = givesBoolean.apply(user);
            System.out.println("Tax is calculated for : " + user.getName() + " Active : " + isActive);
        });


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
