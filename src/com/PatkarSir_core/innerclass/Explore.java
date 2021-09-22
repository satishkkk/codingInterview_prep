package com.PatkarSir_core.innerclass;

/*
* NESTED CLASSES
*   1. Static nested classes
*   2. Non Static nested classes
*       a. Normal inner classes
*       b. method local inner classes
*       c. anonymous inner classes
*
* COMPILER:
* 1. compiler will generate 2 class file
*   -outer.class
*   -outer$inner.class
*
* 2. inner class method can access outer class methood , variable and private variables
*       outer class methods are unable to access inner class data
*
*  3. Outer o = new Outer()
*      Outer.Inner i = o.new Inner();
*
*   USAGE :
*   1. one class required another class only once - increase encapsulation / reading / grouping
*   2. Inner class can access private properties of outer class.
*   3. Methos required class logic only one time then we can use inner class
*   4. one functionality can only exists if and only if other is present
*       for ex : account functionality can exists if and only if bank functionality is present
*
*   ex
*   class bank{
*       class account{}
*   }
*
*   class Map{
 *       class Entry{}
 *   }
 *
*
* */
public class Explore {
    public static void main(String[] args) {
        System.out.println("EXPLORING INNER CLASS:");
        Outer o = new Outer();
        o.m1();
        Outer.Inner i = o.new Inner();
        i.m2();
    }
}

class Outer{
    private int x=10;
    int y=20;

    void m1(){
        System.out.println("OUTER CLASS METHOD M1() with value X:"+ x + " Y:"+ y);
        /* Outer class can not access inner class variables */
//      System.out.println("INNER CLASS NMETHOD M2() with value A:"+a + " B:"+b);
    }

    class Inner{
        int a = 30;
        int b = 40;

        void m2(){
            System.out.println("INNER CLASS NMETHOD M2() with value A:"+a + " B:"+b);
            m1();
            //inner class can access private variable of outer class (for example variable x
            System.out.println("OUTER CLASS private variable from inner class X:"+ x + " Y:"+ y);
        }
    }
}
