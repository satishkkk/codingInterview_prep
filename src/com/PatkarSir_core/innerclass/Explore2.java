package com.PatkarSir_core.innerclass;

/*
* METHOD LOCAL INNER CLASS :
*   1. SCOPE OF THE METHOD LOCAL INNER CLASS WILL BE WITHIN A METHOD.
*   2. outer class can have 5 modifier -> public default final abstract strictfp
*   3. inner class can have 5 modifier and 3 more-> public default final abstract strictfp + static private protected
* */
public class Explore2 {
    public static void main(String[] args) {
        new Outer3().m1(); //not allowed because inner class's scope is just inside the method
    }
}

class Outer3{

    void m1(){
        /* INNER CLASS */
        class Inner3{
            void display(){
                System.out.println("METHOD LOCAL INNER CLASS");
            }
        }
        Inner3 i = new Inner3();
        i.display();
    }

    void m2(){
        /* IN ONE METHOD MULTIPLE INNER CLASSES */
        class Inner4{

        }

        //class Inner5 extends Outer3{//allowed to extedn outer class
        //class Inner5 extends Explore2{//allowed to extends class from same file
        //class Inner5 extends Explore{//allowed
        //class Inner5 extends Inner3{ //NOT ALLOWED . . . . because not visible in scopre
        class Inner5 extends Inner4{

        }
    }
}
