package com.interviewBitScaler.LectureX1_String;

public class reverseString {
    public static void main(String[] args) {
        String s ="       fwbpudnbrozzifml osdt ulc jsx kxorifrhubk ouhsuhf sswz qfho dqmy sn myq igjgip iwfcqq                 ";
        System.out.println(solve(s));
    }

    public static String solve(String A) {

        String reverseString = reverse(A); // reverse whole strin
        char[] arr = reverseString.toCharArray();

        StringBuilder s = new StringBuilder();

        for(int i=0;i<arr.length;){
            while(i<arr.length && arr[i]==' '){
                i++;
            }
            int l =i;

            while(i<arr.length && arr[i]!=' '){
                i++;
            }
            int r = i;

            String out = reverse(reverseString.substring(l,r));
            s.append(out+" ");
        }

        return s.toString().trim();
    }

    public static String reverse(String A){
        char[] arr= A.toCharArray();
        int l=0;
        int r = arr.length-1;

        while(l<r){
            char temp = arr[r];
            arr[r] = arr[l];
            arr[l] =temp;
            r--;
            l++;
        }
        return new String(arr);
    }
}
