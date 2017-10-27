package collection;

import java.util.ArrayList;

/**
 * Created by zafar.imam on 26-09-2017.
 */

public class CompareDemo {

    public static void main(String ...arg){

        ArrayList<Employee> empList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Employee emp = new Employee();
            emp.setId(i);
            emp.setSalary(i*i*i);
            emp.setLocation("loc "+i);
            emp.setName("Name "+i*i);
            empList.add(emp);
        }
    }
}
