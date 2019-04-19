package com.example.logicprogram.java_enum;

/*
* About Enum : https://www.geeksforgeeks.org/enum-in-java/
* */

enum Day
{
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY;
}

enum Color
{
    RED, GREEN, BLUE;
}


/*
* 1) Color enum represents Same as
* */
/*
class Color
{
    public static final Color RED = new Color();
    public static final Color BLUE = new Color();
    public static final Color GREEN = new Color();
}*/

/*
* 2) Every enum constant is always implicitly public static final. Since it is static,
* we can access it by using enum Name. Since it is final, we can’t create child enums.
* */

/*
* 3) We can declare main() method inside enum. Hence we can invoke enum directly from the Command Prompt.
* */

enum Color1
{
    RED, GREEN, BLUE;

    // Driver method
    public static void main(String[] args)
    {
        Color c1 = Color.RED;
        System.out.println(c1);
    }
}

/*
* 4) enum can contain constructor and it is executed separately for each enum constant at the time of enum
* class loading.
* We can’t create enum objects explicitly and hence we can’t invoke enum constructor directly.
* */

/*
* 5) enum can contain concrete methods only i.e. no any abstract method.
* Example as below :
* */

enum Color2
{
    RED, GREEN, BLUE, YELLOW;

    // enum constructor called separately for each
    // constant
    private Color2()
    {
        System.out.println("Constructor called for : " +
                this.toString());
    }

    // Only concrete (not abstract) methods allowed
    public void colorInfo()
    {
        System.out.println("Universal Color");
    }
}

class Test
{
    // Driver method
    public static void main(String[] args)
    {
        Color2 c2 = Color2.RED;
        System.out.println(c2);
        c2.colorInfo();
    }
}