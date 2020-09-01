package com.company.Core;


class Base{

    //During compile time it is decided that display method will bind to the base class
    public static void display(){
        System.out.println("BASE CLASS |  DISPLAY METHOD | STATIC OR CLASS METHOD");
    }
    public void print(){
        System.out.println("BASE CLASS |  PRINT METHOD | INSTANCE METHOD");
    }
}

class Derived extends Base{
    public static void display(){
        System.out.println("DERIVED CLASS |  DISPLAY METHOD | STATIC OR CLASS METHOD");
    }
    public void print(){
        System.out.println("DERIVED CLASS |  PRINT METHOD | INSTANCE METHOD");
    }
}

public class StaticOverriding {
    public static void main(String[] args) {
        Base obj = new Derived();

        obj.display();
        obj.print();

    }
}
