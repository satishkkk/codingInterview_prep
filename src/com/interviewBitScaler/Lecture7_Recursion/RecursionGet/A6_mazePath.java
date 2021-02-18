package com.interviewBitScaler.Lecture7_Recursion.RecursionGet;

import java.util.ArrayList;

public class A6_mazePath {
    public static void main(String[] args) {
        System.out.println("COUNT ______________________________________________");
        System.out.println(countMazePathHorizontalAndVertical(0,0,2,2));
        System.out.println("PRINT ______________________________________________");
        printMazePathHorizontalAndVertical(0,0,2,2,"");
        System.out.println("GET H AND V ______________________________________________");
        ArrayList<String> out = mazePathHorizontalAndVertical(1,1,3,3);
        out.stream().forEach(System.out::println);
        System.out.println("GET H & V & DIAGONAL ______________________________________________");
        ArrayList<String> outd = mazePathHorizontalAndVerticalAndDiagonal(1,1,3,3);
        outd.stream().forEach(System.out::println);
    }

    //COUNT
    public static int countMazePathHorizontalAndVertical(int sx, int sy, int ex, int ey){
        if(sx==ex && sy==ey){
            return 1;
        }
        if(sx>ex || sy>ey){
            return 0;
        }

        int ch = countMazePathHorizontalAndVertical(sx+1,sy,ex,ey);
        int cv = countMazePathHorizontalAndVertical(sx,sy+1,ex,ey);

        return ch+cv;
    }

    //PRINT
    public static void printMazePathHorizontalAndVertical(int sx, int sy, int ex, int ey, String ans){
        if(sx==ex && sy==ey){
            System.out.println(ans);
            return;
        }
        if(sx>ex || sy>ey){
            return;
        }
        printMazePathHorizontalAndVertical(sx+1,sy,ex,ey,ans+"H");
        printMazePathHorizontalAndVertical(sx,sy+1,ex,ey,ans+"V");
    }

    //GET [H & V]
    public static ArrayList<String> mazePathHorizontalAndVertical(int sx,int sy,int ex,int ey){
        if(sx==ex && sy==ey){
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        if(sx>ex || sy>ey){
            ArrayList<String> br = new ArrayList<>();
            return br;
        }

        ArrayList<String> mr = new ArrayList<>();
        ArrayList<String> hMove = mazePathHorizontalAndVertical(sx,sy+1,ex,ey);
        for(String s:hMove){
            mr.add("H"+s);
        }
        ArrayList<String> vMove = mazePathHorizontalAndVertical(sx+1,sy,ex,ey);
        for(String s:vMove){
            mr.add("V"+s);
        }
        return mr;
    }

    //GET [H & V & D]
    public static ArrayList<String> mazePathHorizontalAndVerticalAndDiagonal(int sx,int sy,int ex,int ey){

        if(sx==ex && sy==ey){
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        if(sx>ex || sy>ey){
            ArrayList<String> br = new ArrayList<>();
            return br;
        }

        ArrayList<String> mr = new ArrayList<>();
        ArrayList<String> hMove = mazePathHorizontalAndVerticalAndDiagonal(sx,sy+1,ex,ey);
        for(String s:hMove){
            mr.add("H"+s);
        }
        ArrayList<String> vMove = mazePathHorizontalAndVerticalAndDiagonal(sx+1,sy,ex,ey);
        for(String s:vMove){
            mr.add("V"+s);
        }
        ArrayList<String> dMove = mazePathHorizontalAndVerticalAndDiagonal(sx+1,sy+1,ex,ey);
        for(String s:dMove){
            mr.add("D"+s);
        }
        return mr;
    }
}
