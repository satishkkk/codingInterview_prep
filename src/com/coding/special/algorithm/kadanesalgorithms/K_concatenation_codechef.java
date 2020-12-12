package com.coding.special.algorithm.kadanesalgorithms;

import java.util.Scanner;
/*https://www.codechef.com/problems/KCON*/
public class K_concatenation_codechef {

    static long kadane(int[] input){
        int currentSum = input[0];
        int max_so_far = input[0];
        for(int i =0 ;i< input.length-1;i++){
            currentSum = currentSum+input[i];
            max_so_far = Math.max(currentSum,max_so_far);
            if(currentSum<0)
                currentSum=0;
        }
        return max_so_far;
    }

    static long kCON(int[] input, int n ,int k){
        long kadanes_sum =  kadane(input);

        if(k==1){
            return kadanes_sum;
        }

        //kadanes for two or more
        long curr_prefix_sum = 0 , curr_suffix_sum=0;
        long max_prefix_sum = 0, max_suffix_sum=0;

        for(int i=0;i<input.length;i++){
            curr_prefix_sum = curr_prefix_sum + input[i];
            max_prefix_sum =Math.max(curr_prefix_sum,max_prefix_sum);
        }

        long totalSum = curr_prefix_sum;

        for(int i=input.length-1;i>=0;i--){
            curr_suffix_sum = curr_suffix_sum + input[i];
            max_suffix_sum =Math.max(curr_suffix_sum,max_suffix_sum);
        }

        long answer;
        if(totalSum <0){
            answer = Math.max(max_prefix_sum+max_suffix_sum,kadanes_sum);
        }else{
            answer = Math.max(max_prefix_sum+max_suffix_sum+(totalSum*(k-2)),kadanes_sum);
        }
        return answer;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        try{
            Scanner s = new Scanner(System.in);
            int t = s.nextInt();
            while(t > 0) {
                int n,k;
                n = s.nextInt();
                k = s.nextInt();
                int[] input = new int[n];
                for(int i = 0; i < n; i++) {
                    input[i] = s.nextInt();
                }
                System.out.println(kCON(input, n, k));
            }
        }
        catch(Exception e){}
    }

}
