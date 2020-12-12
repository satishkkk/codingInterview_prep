package com.company.Core.javapassbyvalue;

/*
*  if you change the value of wrapper objects inside the method like this: x += 2,
*  the change is not reflected outside the method since wrapper objects are immutable
*  which means that they create a new instance each time their state is modified.
 * */

public class ExploreWrapperArgument {

    public static void main(String[] args) {

        Integer obj1 = new Integer(1);
        Integer obj2 = new Integer(2);

        System.out.print("Values of obj1 & obj2 before wrapper modification: ");
        System.out.println("obj1 = " + obj1.intValue() + " ; obj2 = " + obj2.intValue());

        modifyWrappers(obj1, obj2);

        System.out.print("Values of obj1 & obj2 after wrapper modification: ");
        System.out.println("obj1 = " + obj1.intValue() + " ; obj2 = " + obj2.intValue());

    }

    private static void modifyWrappers(Integer x, Integer y)
    {
        x = new Integer(5);
        y = new Integer(10);
    }
}
