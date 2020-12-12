package com.coding.special.algorithm.kadanesalgorithms;


import java.util.Scanner;

/* construct a product array p such that p is equal to the product of all the elements of A except A[i].
 The constraint is that you are not allowed to use division operator . .
* also space complexity should be constant
*
* 2
* 5
* 10 3 5 6 2
* 2
* 12 20
*
* 180 600 360 300 900
* 20 12
* */
public class Mindbendingproduct {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i =0 ; i< n ;i++){
                arr[i] = sc.nextInt();
            }
            getMindeBendingproduct(arr);
            t--;
        }
    }

    public static void getMindeBendingproduct(int[] arr){
        long[] productArray = new long[arr.length];

//        Maintain one array
//        First fill left product array
//        Now fill right product array

        long lp =1;
        for(int i=0; i <arr.length;i++){
            productArray[i] = lp;
            lp = lp * arr[i];
        }

        long rp = 1;
        for(int i=arr.length-1; i>=0;i--){
            productArray[i] = productArray[i]*rp;
            rp = rp * arr[i];
        }

        System.out.println("OUTPUT : ");
        for(int i=0; i <productArray.length;i++){
            System.out.println(productArray[i]);
        }
    }
}
