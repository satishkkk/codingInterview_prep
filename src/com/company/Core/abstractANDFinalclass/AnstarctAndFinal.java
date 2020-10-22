package com.company.Core.abstractANDFinalclass;


public class AnstarctAndFinal {
    public static void main(String[] args) {
        System.out.println("Exploring oop");

        final int a =10;
//        a=40;
        C2 obj2 = new C2();
        obj2.deposit(1);
        obj2.withdraw(10);
    }
}

//Abstarct and final both the modifier at same class : you can not have both modifier at the same time
//Abstarct Class : you can not create object of instance class -> compile time error " class is abstarct cannot be instaniated
abstract class C1{

    int balance;
    int lt;
    abstract void deposit(int v);


    final void withdraw(int v){
        System.out.println("This is final withdraw of C1");
    }
}
//Final class you can not inheriate the final class. ..
class C2 extends C1 {

    @Override
    void deposit(int v) {

    }

//
//    void withdraw(int v){
//        System.out.println("This is final withdraw of C2");
//    }
}
