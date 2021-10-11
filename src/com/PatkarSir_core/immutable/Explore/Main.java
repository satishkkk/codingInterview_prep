package com.PatkarSir_core.immutable.Explore;

public class Main {

    public static void main(String[] args) {

        System.out.println("-------------------MUTABLE------------------");
        Age age = new Age();
        age.setDay(1);
        age.setMonth(1);
        age.setYear(1992);

        MutableStudent student = new MutableStudent(1,"Satish", age);

        System.out.println("Satish age year before modifications " + student.getAge().getYear());
        age.setYear(1993);
        System.out.println("Satish age year after modifications " + student.getAge().getYear());

        System.out.println("-------------------IMMUTABLE------------------");

        Age newage = new Age();
        newage.setDay(1);
        newage.setMonth(1);
        newage.setYear(2020);

        ImmutableStudent immutableStudent = new ImmutableStudent(2,"Satish", newage); // age is 1992

        System.out.println("Satish age year before modifications " + immutableStudent.getAge().getYear());
        newage.setYear(2019);
        System.out.println("Satish age year after modifications " + immutableStudent.getAge().getYear());

    }
}
