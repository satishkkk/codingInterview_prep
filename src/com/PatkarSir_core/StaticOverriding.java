package com.PatkarSir_core;

//TODO : https://www.geeksforgeeks.org/can-we-overload-or-override-static-methods-in-java/
/*PARENT CLASS*/
class Parent{
    // TODO: During compile time it is decided that display method will bind to the Parent class
    public static void display(){
        System.out.println("Parent CLASS |  DISPLAY METHOD | STATIC OR CLASS METHOD");
    }
//    TODO :COMPILE TIME ERROR :cannot redefine display(): you can not write same method defination one is  static and other is Instance method
//    public void display(){
//        System.out.println("Parent CLASS |  DISPLAY METHOD | NOT STATIC OR INSTANCE METHOD");
//    }
    public void print(){
        System.out.println("Parent CLASS |  PRINT METHOD | INSTANCE METHOD");
    }
}

/*CHILD CLASS*/
class Child extends Parent{
    //TODO:During compile time it is decided that display method will bind to the CHILD class
    //TODO: Static method can't be override. . . This is called method hiding . . .
    public static void display(){
        System.out.println("Child CLASS |  DISPLAY METHOD | STATIC OR CLASS METHOD");
    }
    public void print(){
        System.out.println("Child CLASS |  PRINT METHOD | INSTANCE METHOD");
    }
}

public class StaticOverriding {
    public static void main(String[] args) {

        Parent parent = new Parent();
        System.out.println("PRINTING PARENT OBJECT . . . ---------------------------");
        parent.display(); // TODO: Ideal way to access static method is CLASSNAME.METHODNAME . . .But in java you can access static method with object name also (not allowed in C#)
//        Parent.display(); TODO ideal way to call staticmethod via class name
        parent.print();

        Parent parentReferenceWithChildObj = new Child();
        System.out.println("PRINTING CHILD OBJECT . . .  ---------------------------");

        parentReferenceWithChildObj.display(); //TODO:This is called method hiding it will call to method based on object reference type here its Parent. . .and not according to object being referred. . .
        parentReferenceWithChildObj.print();

        Child child = new Child();
        System.out.println("PRINTING CHILD OBJECT . . .  ---------------------------");
        child.display(); //TODO: it will call child' method as refernce is child
        child.print();
    }
}

/*
* 1. Can we overload two static method ? YES  We can have two ore more static methods with same name, but differences in input parameters.
* 2. Can we overload methods that differ only by static keyword? NO it will give compile time error . cannot redefine  . .We cannot overload two methods in Java if they differ only by static keyword
* 3. Can we Override static method ? "NO" It will be method hiding and not overriding but it will notgive any error
* We can declare static methods with same signature in subclass, but it is not considered overriding as there won’t be any run-time polymorphism. Hence the answer is ‘No’.
  If a derived class defines a static method with same signature as a static method in base class, the method in the derived class hides the method in the base class.
* */

/*      1) For class (or static) methods, the method according to the type of reference is called, not according to the object being referred, which means method call is decided at compile time.
          2) For instance (or non-static) methods, the method is called according to the type of object being referred, not according to the type of reference, which means method calls is decided at run time.
          3) An instance method cannot override a static method, and a static method cannot hide an instance method. For example, the following program has two compiler errors.
          4) In a subclass (or Derived Class), we can overload the methods inherited from the superclass. Such overloaded methods neither hide nor override the superclass methods — they are new methods, unique to the subclass.*/