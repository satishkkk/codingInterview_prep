package com.interviewBitScaler.Lecture6_BinarySearchApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllocateBooks {

    public static void main(String[] args) {
        int[] a = new int[]{12,34,67,90};
        int b =2;
        System.out.println(books(a,b));
    }

    public static int books(int[] A, int B) {
        if(A.length < B) return -1; // if number of students are more then number of books

        int sum =0 ; //max possible value
        int max =0 ; //min possible value

        for(int i=0;i<A.length;i++){
            max = Math.max(A[i],max);
            sum += A[i];
        }
        int ans =Integer.MAX_VALUE;
        int start = max;
        int end = sum;

        while(start <= end){
            int mid = (end + start)/2;

            if(isPossible(A,B,mid)){
                //increase the range
                ans = Math.min(ans,mid); //if distribution of mid is possible .. then we should try with smaller number as we want to minimize the answer
                end = mid -1;
            }else{
                //if mid is not possible then increase the range
                start =mid+1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int[] A, int B,int curr_ans) {

        int sum = 0;
        int reuired_student_count = 1; //assuming we can distribute pages to one student

        for(int i=0;i<A.length;i++){
            if( sum + A[i] > curr_ans){
                reuired_student_count++;
                sum=A[i];
                if(reuired_student_count > B){
                    return false;
                }
            }else{
                sum += A[i];
            }
        }
        return true;
    }




//APPROCH 2 :

    public static int books1(int[] A, int B) {
        if(A.length < B) return -1;

        int sum =0 ;
        int max =0 ;
        for(int i=0;i<A.length;i++){
            max = Math.max(A[i],max);
            sum += A[i];
        }
        int ans =Integer.MAX_VALUE;
        int start = max;
        int end = sum;

        while(start <= end){
            int mid = (end + start)/2;

            int count = 0;
            int tempSum =0;
            int i=0;
            while(i<A.length){
                tempSum +=A[i];
                if(tempSum > mid){
                    count++;
                    tempSum=A[i];
                }else if(tempSum == mid){
                    count++;
                    tempSum=0;
                }
                i++;
            }
            if(tempSum > 0) count++;

            if(count > B){
                start=mid+1;
            }
            else {
                ans =Math.min(ans,mid);
                end = mid-1;
            }
        }
        return ans;
    }
}
