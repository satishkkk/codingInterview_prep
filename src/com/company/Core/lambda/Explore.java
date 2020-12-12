package com.company.Core.lambda;


/*
* Java 8
* 1. reduce the length of java class
* 2. reduce the byte code
*
* FUNCTIONAL INTERFACE : Interface that only contains one functional method.  (means only one abstarct method) it allows to contain more default or static methosa
* java 7 : abstract method  {allowed in interrface}
* java 8 : abstract , default , static method {all three types of method allowed in interface }
*
* Lambda expression will provide only implementation of functional interface
* */
public class Explore {

    public static void main(String[] args) {

        //application with anonymous inner class
       new I1() {
          @Override
          public void m1(){
              System.out.println("annonymous class");
          }
        }.m1();

       //LAMBDA WAY
        //SYNTAX  (args) -> expression
        I1 i1 = () -> System.out.println("THIS IS LAMBDA");
        i1.m1();

        //as I4 is not a valid functional interface hence its not allowing to write lamda
//        I4 i4 = () -> System.out.println("TRYING TO CRETAE ANOTHER LAMDA");

        //passing args with annonymous class
        I2 i2 = new I2(){
            @Override
            public void add(int a,int b){
                System.out.println("sum is "+ a+b);
            }
        };
        i2.add(1,2);

        //args with lambda
        I2 i21 = (int a,int b) -> {
            int sum = a+b;
            System.out.println("Adding two variable and printing sum"+ sum);
        };
        i21.add(5,6);

        //type is not mandatory
        I2 i22 = (a, b) -> {
            int sum = a+b;
            System.out.println("Adding two variable and printing sum"+ sum);
        };

        I3 i31 = (str) -> {
            System.out.println("ECHO RETURNOING" +str);
            return str;
        };
        String strEcho =i31.echo("ECHO");
        System.out.println(strEcho);

        I3 i32 = (String str1) -> str1; // if single return value thenreturn keyword id optional
        i32.echo("hello");
    }
}


//VALID FUNCTIONAL INTERFACE
interface I1{
    void m1();
}

//VALID FUNCTIONAL INTERFACE
interface I2{
    void add(int a , int b);
    default void m2(){};
}

//VALID FUNCTIONAL INTERFACE
interface I3{
    String echo(String echo);
    default void m2(){};
    static void m3(){};
}

//Invalid functional interface because it has two abstract method
interface I4{
    void m1();
    void m2();
}