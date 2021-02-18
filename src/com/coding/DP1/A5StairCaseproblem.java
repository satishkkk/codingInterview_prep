package com.coding.DP1;

//Similar to fibonaaci series . . . .
public class A5StairCaseproblem{
    public static void main(String[] args) {
        int n = 10;
        System.out.println(stairCaseDP(n));
    }

    static long stairCaseDP(int n){
        long[] out = new long[n+1];
        //very important you missed it
        if(n==0) {
            return 1;
        }

        if(n==1 || n==2){
            return n;
        }

        out[0]=1;
        out[1]=1;
        out[2]=2;

        for(int i =3;i<=n;i++){
            out[i] = out[i-1]+out[i-2]+out[i-3];
        }
        return out[n];
    }

    static int stairCase(int n){
        if(n==0){
            return 1;
        }if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }

        int out = stairCase(n-1)+stairCase(n-2)+stairCase(n-3);
        return out;
    }
}

/*
* A child runs up a staircase with 'n' steps and can hop either 1 step, 2 steps or 3 steps at a time. Implement a method to count and return all possible ways in which the child can run-up to the stairs.
Input format :
The first and the only line of input contains an integer value, 'n', denoting the total number of steps.
Output format :
Print the total possible number of ways.
 Constraints :
0 <= n <= 10 ^ 4

Time Limit: 1 sec
Sample Input 1:
4
Sample Output 1:
7
Sample Input 2:
10
Sample Output 2:
274*/