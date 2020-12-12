package com.company.Core.exceptionhandling.userdefinedexception;


interface I1{
    void m1() throws E31;
    void m2() throws E32;
}

class C31{
    void g1(){
        System.out.println("g1 of C31");
    }
    void g2() throws E3{
        System.out.println("g2 of C31");
    }
}

class C32 extends C31 implements I1{

    @Override
    public void m1(){
        System.out.println("m1 of C32");
    }

    @Override
    public void m2() throws E32 {
        System.out.println("m2 of C32");
    }

    @Override
    void g2() throws E4{
        System.out.println("g2 of C32");
    }
}

public class LearningOverridingThrows {

    public static void main(String[] args) {
        C31 c31 = new C31();
        C32 obj = new C32();
        obj.m1();
        try {
            obj.m2();
        }catch(E32 e){
            System.out.println("E32 Caught");
        }
        obj.g1();
        try{
            obj.g2();
        }catch(E4 e){
            System.out.println("E4 Caught");
        }
        client1(obj);
        client2(c31);
        client2(obj);
    }

    static void client1(I1 h){
        try {
            h.m1();
        } catch (E31 ex) {
            System.out.println("E31 caught in client1");
        }
        try {
            h.m2();
        } catch (E32 ex) {
            System.out.println("E32 caught in client1");
        }
    }

    static void client2(C31 h){
        h.g1();
        try {
            h.g2();
        } catch (E3 ex) {
            System.out.println("E3 caught in client2");
        }
    }
}

class E31 extends Exception {

}

class E32 extends Exception {

}

class E3 extends Exception {

}

class E4 extends E3 {

}

class E5 extends Exception {

}
