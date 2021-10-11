package com.PatkarSir_core.constructor;

public class static_Instance_block {

    public static void main(String[] args) {

        test t1 = new test(10);
    }
}

class test{


    int x=5;

    static{
        System.out.println("STATIC BLOCK");
    }

    {
        System.out.println("value of x inside the 1 instance block "+x);
    }

    test(int x){
        this.x=x;
        System.out.println("THIS IS CONSTRUCTOR"+x);
    }
    
    {
        x=15;
        System.out.println("value of x inside the 2 instance block "+x);
    }

    {
        System.out.println("value of x inside the 3 instance block "+x);
    }


}
