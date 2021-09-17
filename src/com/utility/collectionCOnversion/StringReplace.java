package com.utility.collectionCOnversion;

public class StringReplace {

    public static void main(String args[]){
        String inputString = "M S K    ";
        int originalLength = 5;

        char[] input = inputString.toCharArray();
        int n = inputString.length();
        int emptySpace = 0;
        for(int i=0;i<originalLength;i++){
            if (input[i] == ' ') emptySpace++;
        }
        int rigthIndex=n-1;
        int  leftIndex=rigthIndex-2*emptySpace;
        for(int i = leftIndex;i>=0;i--){
            if(input[i] == ' '){
                input[rigthIndex] = '0';
                input[rigthIndex-1] = '2';
                input[rigthIndex-2] = '%';
                rigthIndex-=3;
            }else{
                input[rigthIndex--] = input[i];
            }
        }
        System.out.println(String.valueOf(input));
    }
}
