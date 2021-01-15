package com.coding.strings;

public class ReducedStringHackerRank {

    public static void main(String[] args) {
        String str ="baab";
        System.out.println(superReducedString(str));
    }

    static String superReducedString(String s) {
        StringBuffer sb = new StringBuffer(s);

//        StringBuffer a = sb.delete(1,2);
//        System.out.println(a);
        for(int i=1; i<sb.length() ; i++){
            if(sb.charAt(i-1) == sb.charAt(i)){
                sb.delete(i-1,i+1);
                i=0;
            }
        }
        if(sb.length()==0)
            return "Empty String";
        else
            return sb.toString();
    }
}
