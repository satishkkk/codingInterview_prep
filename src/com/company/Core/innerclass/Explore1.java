package com.company.Core.innerclass;

/*
*  LEARNING
*
*  1.
*  access inner class variable as this.#VARIABLE_NAME#
*  access outer class variable as #OUTER_CLASS_NAME#.this.#VARIABLE_NAME#
*
*
 * 2. you can not declare static variable , method or block in inner class
 *
 * 3. constructor , instance block and static block can be declared in outer blocks
*
*  4. ORDER OF EXECUTION :
*   1. OUTER STATIC BLOCK (IN order of appearance)
*   2. OUTER INSTANCE BLOCK
*   3. OUTER CONSTRUCTOR
*       NOT AN INNER STATIC BLOCK -> BECAUSE INNER CLASS DOES NOT HAVE STATIC BLOCK.
*   4. INNER INSTANCE BLOCK
*   5. INNER CONSTRUCTOR
*
* */
public class Explore1 {
    public static void main(String[] args) {
        System.out.println("Exploring innerclass");
        new Outer1().new Inner1().add(1000,2000);
    }
}

class Outer1{
    int a=10;
    int b=20;

    Outer1(){ // CONSTRUCTOR
        System.out.println("Inside the OUTER CLASS constructor");
    }

    { // INSATNCE BLOCK
        System.out.println("Inside the OUTER CLASS instance block");
    }

    static{ // STATIC BLOCK execute in order of occurence
        System.out.println("Inside OUTER CLASS static block 1");
    }

    static{ // STATIC BLOCK
        System.out.println("Inside OUTER CLASS static block 2");
    }

    class Inner1{
        int a=100;
        int b=200;
        // static int x =19;//COMPILE TIME ERROR : inner class can not have static variable
        // no static var ,method or block allowed ...so main method is also not allowed
        final static int c =10; // allow only constant variable declaration  - whihch means final static allowed

        Inner1(){
            System.out.println("Inside the INNER CLASS constructor");
        }
        { // INSATNCE BLOCK
            System.out.println("Inside the INNER CLASS instance block");
        }
        /*static{ //STATIC BLOCK NOT ALLOWED
            System.out.println("Inside INNER CLASS static block ");
        }*/

        void add(int a , int b){
            System.out.println(a+b);//access variable of local class
            System.out.println(this.a+this.b);//access variable of inner class
            System.out.println(Outer1.this.a+Outer1.this.b); //access variable of outer class
        }
    }
}
