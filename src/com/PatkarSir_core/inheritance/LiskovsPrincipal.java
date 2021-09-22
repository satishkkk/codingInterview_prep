package com.PatkarSir_core.inheritance;

public class LiskovsPrincipal {

    public static void main(String[] args) {
        C1 obj1  = new C1();
        obj1.initC1(1,2);
        obj1.print();

        C2 obj2 = new C2();
        obj2.initC2();
        obj2.print();
        obj2.print(); //liskovs principal child can do everything . . . he can acess all the mrthod of himself as well as all the methods of parent class . . .
    }
}


class C1 {
    private int a;
    private int b;

    void initC1(int a, int b){
        this.a=a;
        this.b=b;
    }

    public void print() {
        System.out.println("CLASS C1:a"+a);
        System.out.println("CLASS C1:b"+b);
    }
}

class C2 extends C1 {
    private int c;
    private int d;

    void initC2(){
        initC1(10,20);
        c = 30;
        d = 40;

    }

    @Override
    public void print() {
        super.print();
        System.out.println("CLASS C2:C"+c);
        System.out.println("CLASS C2:D"+d);
    }
}
