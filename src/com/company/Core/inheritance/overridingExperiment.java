package com.company.Core.inheritance;


class Parent{
    ParentReturnType show(){
        System.out.println("Parent : SHOW ");
        return new ParentReturnType();
    }
}

class Child extends Parent{
    @Override
    ChildReturnType show(){
        System.out.println("Child : SHOW ");
        return new ChildReturnType();
    }
}

public class overridingExperiment {
    public static void main(String[] args) {
        Child c =new Child();
        c.show();
    }
}

class ParentReturnType{

}

class ChildReturnType extends ParentReturnType{

}
