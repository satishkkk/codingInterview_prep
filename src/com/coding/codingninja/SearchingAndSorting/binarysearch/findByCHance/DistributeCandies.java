package com.coding.codingninja.SearchingAndSorting.binarysearch.findByCHance;

import java.util.Scanner;

public class DistributeCandies {

    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test>0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] candyNum = new int[n];
            for(int i=0;i<n;i++){
                candyNum[i] = sc.nextInt();
            }
            int high =0;
            for(int i=0;i<n;i++){
                high = Math.max(high,candyNum[i]);
            }

            int low =0;
            int mid=0;
            int result=0;

            while(low <=high){
                mid = low+(high-low)/2;
                if(isValid(candyNum,n,k,mid)){
                    result = mid;
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
            System.out.println(result);
            test--;
        }
    }

    public static boolean isValid(int[] candyNum,int n,int k,int mid){
        for(int i=0;i<n;i++){
            k = k - (candyNum[i]/mid);

            if(k<=0)
                return true;
        }
        return false;
    }
}

/*
* Shaky has N (1<=N<=50000) candy boxes each of them contains a non-zero number of candies (between 1 and 1000000000). Shaky want to distibute these candies among his K (1<=K<=1000000000) IIIT-Delhi students. He want to distibute them in a way such that:
1. All students get equal number of candies.
2. All the candies which a student get must be from a single box only.
As he want to make all of them happy so he want to give as many candies as possible. Help Shaky in finding out what is the maximum number of candies which a student can get.
Input
First line contains 1<=T<=20 the number of test cases. Then T test cases follow. First line of each test case contains N and K. Next line contains N integers, ith of which is the number of candies in ith box.
Output
For each test case print the required answer in a seperate line.
Sample Input:
2
3 2
3 1 4
4 1
3 2 3 9
Sample Output:
3
9*/