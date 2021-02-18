package com.coding.recursion;
import java.util.Scanner;
public class findLength {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(length(str));
        System.out.println(length1(str,str.length()-1));
    }

    static int length(String str){
        if(str==null || str.length()==0){
            return 0;
        }
        int result = length(str.substring(0,str.length()-1));
        return result+1;
    }

    //effcient so;ution
    static int length1(String str,int index){
        if(index==-1){
            return 0;
        }
        int result = length1(str,index -1);
        return result+1;
    }
}
