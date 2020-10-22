package com.company.designpattern.templatemethodpattern;

public class GreenPiggy implements Piggy {

    int balance;

    int lt;

    public void deposit(int v) {
        balance = balance + v;
        lt = v;
    }

    public void withdraw(int v) {
        if(balance >= v) {
            balance = balance -v ;
            lt = -v;
        }
    }

    public void statement() {

        System.out.println("Printing Statement");
        System.out.println("Balance = "+balance);
        System.out.println("Last Transaction = "+lt);

    }

    public void a(){
        System.out.println("a");
    }
}
