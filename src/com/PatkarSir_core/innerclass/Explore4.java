package com.PatkarSir_core.innerclass;
/*
*   ANNONYMOUS INNER CLASSES :
*
*
*
* */
public class Explore4 {

    public static void main(String[] args) {
        System.out.println("EXPLORING ANNONYMOUS INNER CLASS");

        //create class
        A a = new A(){
          @Override
          void display(){
              System.out.println("without Annonymous Inner class ");
          }
        };
        //call method
        a.display();

        // notice that we are creating object of abastract class. . .wehich is not possible in java so internally how it will work ?
        // this will internally create new class which will extend class B and implemnts the method written in side the annonymous class here method annonymousDisplay. .
        // and then gives the object of taht class
        new B(){
            @Override
            void annonymousDisplay() {
                System.out.println("Annonymous Inner class ");
            }
        }.annonymousDisplay();

    }
}

abstract class A{
    abstract void display();
}

abstract class B{
    abstract void annonymousDisplay();
}
