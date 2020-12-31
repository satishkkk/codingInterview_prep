package com.coding.codingninja;

import java.util.Arrays;

public class rotateArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2, 3, 4, 5, 6, 7};
        int d = 2;
        rotate(arr,d); //withlut extra space
        rotate1(arr,d); //with O(N) space
    }

    public static void rotate(int[] arr, int d) {
        //Your code goes here
        if(arr.length == 0){
            return;
        }
//        update D if D is greter then length of array
        if(d>= arr.length && arr.length != 0){
            d %= arr.length;
        }

        reverse(arr, 0 , arr.length-1); //reverse whole array
        reverse(arr, 0 , arr.length-d-1); //reverse firest part
        reverse(arr, arr.length-d , arr.length-1); //reverse last part
        Arrays.stream(arr).forEach(a-> System.out.println(a));
    }

    private static void reverse(int[] arr, int start ,int end){
        while(start < end){
            swapElement(arr,start,end);
            start+=1;
            end-=1;
        }
    }

    private static void swapElement(int[ ]arr, int start ,int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }


    public static void rotate1(int[] arr, int d) {
        //Your code goes here
        int rotate = d==0 ? d : d>arr.length ? arr.length % d : d;
        int[] out = new int[arr.length];
        int i,j;
        for(i=rotate,j=0;i< arr.length;i++,j++){
            out[j] = arr[i];
        }
        for(i =0 ; i<rotate; i++,j++){
            out[j]=arr[i];
        }
        System.arraycopy(out,0,arr,0,arr.length);
        Arrays.stream(arr).forEach(a-> System.out.println(a));
    }
}

/*
You have been given a random integer array/list(ARR) of size N. Write a function that rotates the given array/list by D elements(towards the left).
 Note:
Change in the input array/list itself. You don't need to return or print the elements.
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

First line of each test case or query contains an integer 'N' representing the size of the array/list.

Second line contains 'N' single space separated integers representing the elements in the array/list.

Third line contains the value of 'D' by which the array/list needs to be rotated.
Output Format :
For each test case, print the rotated array/list in a row separated by a single space.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^4
0 <= N <= 10^6
0 <= D <= N
Time Limit: 1 sec
Sample Input 1:
1
7
1 2 3 4 5 6 7
2
Sample Output 1:
3 4 5 6 7 1 2
Sample Input 2:
2
7
1 2 3 4 5 6 7
0
4
1 2 3 4
2
Sample Output 2:
1 2 3 4 5 6 7
3 4 1 2
* */