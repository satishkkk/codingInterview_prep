package com.coding.DP1;

public class A1Fibonacci {
    public static void main(String[] args) {
        int num = 45;

        int[] arr = new int[100];
        int outdp = dpfibonacci(num,arr);
        System.out.println(outdp);

        int out = fibonacci(num);
        System.out.println(out);

        int outi = fibitritive(num);
        System.out.println(outi);
    }

    //Time Complexity 2^n
    public static int fibonacci(int num){
        if(num==0 || num ==1){
            return 1;
        }
        return fibonacci(num-1)+fibonacci(num-2);
    }

    //Time Complexity 2n

    //get array of size n+1 , with inital value as 0
    //stor the value of calculated fibonaci in araay
    //next time ,first find value of finbo from array and if not present then calculate
    public static int dpfibonacci(int num, int[] arr){
        if(num==0 || num ==1){
            return 1;
        }
        if(arr[num]>0){
            return arr[num];
        }
        int output = dpfibonacci(num-1,arr)+dpfibonacci(num-2,arr);
        arr[num] = output;
        return output;
    }


    public static int fibitritive(int n){
        int[] arr = new int[n+1];

        arr[0] =1;
        arr[1] =1;

        for(int i=2;i<=n;i++){
           arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}
