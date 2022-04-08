package com.test.kotlinpractice.kotlin_language

class KotlinInterfaces {
}

/*
* Interfaces A and B both declare functions foo() and bar(). Both of them implement foo(),
* but only B implements bar() (bar() is not marked as abstract in A, because this is the default for interfaces
* if the function has no body). Now, if you derive a concrete class C from A, you have to override bar() and
* provide an implementation.
* However, if you derive D from A and B, you need to implement all the methods that you have inherited from
* multiple interfaces, and you need to specify how exactly D should implement them. This rule applies both to
* methods for which you've inherited a single implementation (bar()) and to those for which you've inherited
* multiple implementations (foo()).
* */

interface A {
    fun foo() {
        print("A")
    }

    //abstract fun bar()
    fun bar()       // If no body is provided then by Default this func treated as abstract.
    // And needs to be implemented whichever class implements his interface
}

interface B {
    fun foo() {
        print("B")
    }

    fun bar() {
        print("bar")
    }
}

class C : A {
    override fun bar() {
        print("bar")
    }
}

class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super.bar()
    }

}