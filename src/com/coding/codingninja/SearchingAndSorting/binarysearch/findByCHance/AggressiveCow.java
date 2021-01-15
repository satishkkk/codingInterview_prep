package com.coding.codingninja.SearchingAndSorting.binarysearch.findByCHance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// APPLICATION OF BINARY SEARCH
public class AggressiveCow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        while (test != 0) {
            int n, cow;
            String ip[] = (br.readLine()).split("\\s+"); // read n and m
            n = Integer.parseInt(ip[0]);
            cow = Integer.parseInt(ip[1]);

            long position[] = new long[n];
            for (int i = 0; i < n; i++) {
                position[i] = Long.parseLong(br.readLine());
            }
            Arrays.sort(position);

            //write your logic here
            long start = 0,end = position[n - 1] - position[0],currentendMaxDistance = 0,mid;

            while (start <= end) {
                mid = (start + end) / 2;
//                mid = start + (end-start)/2;
                if (isValidDistance(position, cow, mid)) {
                    currentendMaxDistance = Math.max(mid, currentendMaxDistance);
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            System.out.println(currentendMaxDistance);
            test--;
        }
    }

    public static Boolean isValidDistance(long[] positions, long numberOfCow, long distance) {
        int count =1;
        long last_position = positions[0];

        for(int i=1;i<positions.length;i++){
            if(positions[i] - last_position >= distance){
                last_position = positions[i];
                count++;
            }
            if(count == numberOfCow)
                return true;
        }
        return false;
    }

}

/*
* Aggressive Cows Problem
Send Feedback
Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls.
 The stalls are located along a straight line at positions x1,...,xN (0 <= xi <= 1,000,000,000).
His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall.
To prevent the cows from hurting each other, FJ wants to assign the cows to the stalls, such that the startimum distance between any two of them is as large as possible.
 What is the largest startimum distance?
Input
t – the number of test cases, then t test cases follows.
* Line 1: Two space-separated integers: N and C
* Lines 2..N+1: Line i+1 contains an integer stall location, xi
Output
For each test case output one integer: the largest startimum distance.
Sample Input :
1
5 3
1
2
8
4
9
Sample Output:
3
Output details:
FJ can put his 3 cows in the stalls at positions 1, 4 and 8,
resulting in a startimum distance of 3.
* */