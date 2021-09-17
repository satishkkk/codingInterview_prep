package com.leetcode.Array101;

public class AddBinaryNumber {
    public static void main(String[] args) {
        String a = "1";
        String b = "111";
        int lengthA = a.length();
        int lengthB = b.length();
        String out = lengthA>lengthB ? addBinaryNumber(a,b) : addBinaryNumber(b,a);
        System.out.println(out);
    }

    public static String addBinaryNumber(String a,String b){
        int lengthA = a.length();
        int lengthB = b.length();

        int numberOfZero = lengthA-lengthB;
        while(numberOfZero>0){
            b = '0'+b;
            numberOfZero--;
        }

        StringBuilder sb = new StringBuilder();
        int carry =0;
        for(int i=lengthA-1;i>=0;i--){
            int bitA = Character.getNumericValue(a.charAt(i));
            int bitB = Character.getNumericValue(b.charAt(i));
            sb.insert(0,bitA^bitB^carry);
            carry = Math.max( Math.max(bitA & bitB , bitA & carry), (bitB & carry));
        }
        if (carry == 1) sb.insert(0,1);

        return sb.toString();
    }
}
