package com.example.logicprogram.design_pattern.c_behavioral_pattern.a_strategy_pattern;

// The interface is implemented by many other
// subclasses that allow for many types of flying
// without effecting Animal, or Flys.

// Classes that implement new Flys interface
// subclasses can allow other classes to use
// that code eliminating code duplication

// I'm decoupling : encapsulating the concept that varies
public interface Flys {
    String fly();
}
