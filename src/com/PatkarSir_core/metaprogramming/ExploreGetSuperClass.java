package com.PatkarSir_core.metaprogramming;

public class ExploreGetSuperClass {
    public static void main(String[] args)
    {
        System.out.println("Welcome to LearingReflection");
        String str = "Hello World";
        System.out.println("Obtaining Meta Object of str");
        Class c = str.getClass();
        System.out.println("str belongs to type " + c.getName());
        Class s = c.getSuperclass();
        System.out.println("The Parent is :");
        System.out.println(s.getName());
        Class [] stypes = c.getInterfaces();
        System.out.println("The Interface SuperTypes are :");
        for(Class i : stypes)
        {
            System.out.println(i.getName());
        }

    }

}
