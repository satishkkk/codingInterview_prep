package com.company.designpattern.templatemethodpattern;

public class Program {

    public static void main(String[] args) {
        GreenPiggy pg1 = new GreenPiggy();
        RedPiggy pg2 = new RedPiggy();
        Client(pg1);
        Client(pg2);
    }
    static void Client(Piggy pg) {

        pg.deposit(200);

        pg.deposit(40);

        pg.withdraw(33);

        pg.statement();


    }

//    static void GreenClient(GreenPiggy pg) {
//        pg.deposit(200);
//        pg.deposit(40);
//        pg.withdraw(33);
//        pg.statement();
//    }
//
//    static void RedClient(RedPiggy pg) {
//        pg.deposit(200);
//        pg.deposit(40);
//        pg.withdraw(33);
//        pg.statement();
//    }

}
