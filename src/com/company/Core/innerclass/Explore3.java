package com.company.Core.innerclass;
/*
*  STATIC INNER CLASS
*  1. static inner class can access only static memeber of outer class. where as normal inner class can access both static and inner fields
*  2.  static declaraton is possible in static inner class and not possible in non sattic inner class
*
* */
public class Explore3 {

    public static void main(String[] args) {
        System.out.println("EXPLORING STATIC INNER CLASS");

        //when you write bracket () you are createing instance of class , so you can access both instance & static fields
        int a = new Outer4().a;
        int b = new Outer4().b;

        // when you write new keyword it will create instance . . . .so you can access instance field of inner classes . .focuson brackets of inner i.e inner4()
        new Outer4.Inner4().display();

        // without new we can access only static fields . . . access static method of static iunner class using outer class
        Outer4.Inner4.anotherDisplay();
        //but if you add () then it will create insatnce and instance object can access tstaic field
        new Outer4.Inner4().anotherDisplay();

    }
}

class Outer4{
    int a = 10;
    static int b = 20;

    static class Inner4{
        void display(){
            //System.out.println("instance a : "+a); // ERROR : instance variabler of outer class is not allowed inside a static inner class
            System.out.println("static b : "+b);
        }

        static void anotherDisplay(){
            System.out.println("INSIDE STATIC INNER METHOD OF STATIC INNER CLASS");
        }
    }
}
