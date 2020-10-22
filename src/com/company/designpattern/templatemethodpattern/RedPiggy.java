package com.company.designpattern.templatemethodpattern;

public class RedPiggy implements Piggy{

    int currentbalance;

    int previousbalance;

    public void deposit(int v) {
        previousbalance = currentbalance;
        currentbalance = currentbalance + v;
    }

    public void withdraw(int v) {

        if(currentbalance >= v) {
            previousbalance = currentbalance;
            currentbalance = currentbalance - v ;
        }

    }

    public void statement() {
        System.out.println("Printing Statement");
        System.out.println("Balance = "+ currentbalance);
        System.out.println("Last Transaction = "+ (currentbalance-previousbalance));

    }
}
