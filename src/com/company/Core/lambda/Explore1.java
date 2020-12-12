package com.company.Core.lambda;

public class Explore1 {

    //    ..method which takes interface as an argument
    static void greet(Message m){
        m.displayMessage();
    }

    public static void main(String[] args) {
        //APPROCH 1 : normal approch
        Explore1.greet(new MyClass());

        //APPROCH 2 : anonymous
        Explore1.greet( new Message(){
            public void displayMessage(){
                System.out.println("GOOD MORNING FROM ANONYMOUS CLASS");
            }
        });

        //APPROCH 3 : Lambda
        Explore1.greet( () -> System.out.println("GOOD MORNING FROM LAMBDA"));
    }

}

// Functional Interface
interface Message{ void displayMessage();}

//class that implements functional intrface Message
class MyClass implements Message{
    public void displayMessage(){
        System.out.println("Good Morning from class");
    }
}
