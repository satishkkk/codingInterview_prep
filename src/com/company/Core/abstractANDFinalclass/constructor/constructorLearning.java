package com.company.Core.abstractANDFinalclass.constructor;

public class constructorLearning {

    public static void main(String[] args) {
        C3 c3 = new C3();
    }
}

class C1{

    C1(){
        System.out.println("Constructor of C1");
    }
}


class C2 extends C1{

    C2(){
        System.out.println("Constructor of C2");
    }
}


class C3 extends C2{

    C3(){
        System.out.println("Constructor of C3");
    }
}
