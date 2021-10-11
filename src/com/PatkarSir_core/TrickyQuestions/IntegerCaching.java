package com.PatkarSir_core.TrickyQuestions;

/*Integer caching
* https://dzone.com/articles/java-integer-cache-why-integervalueof127-integerva
* */
public class IntegerCaching {
    public static void main(String[] args){
        Integer num1 = 127;
        Integer num2 = 127;
        if(num1==num2){
            System.out.println("int value less then 127 comparision :num1 == num2");
            /*
            *It will print “num1 == num2”. Whenever two different object references are compared using “==,”
            * the value is always “false.” But here, because of the Integer caching, num1 and num2 are autoboxed.
            * Thus num1==num2 returns “true”. Integer caching happens only for values between -128 and 127.
            * */
        }
        else{
            System.out.println("num1 != num2");
        }



        Integer num3 = 128;
        Integer num4 = 128;
        if(num3==num4){
            System.out.println("int value moore then 127 comparision : num1 == num2");
        }
        else{
            System.out.println("int value moore then 127 comparision :  num1 != num2");
        }

        Integer num5 = new Integer(100);
        Integer num6 = new Integer(100);
        if(num5==num6){
            System.out.println("new Object reference comparision : num1 == num2");
        }
        else{
            System.out.println("new Object reference comparision : num1 != num2");
        }

    }
}
