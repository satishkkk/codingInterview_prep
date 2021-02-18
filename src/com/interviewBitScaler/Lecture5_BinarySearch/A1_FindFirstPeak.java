package com.interviewBitScaler.Lecture5_BinarySearch;

public class A1_FindFirstPeak {
    public static void main(String[] args) {
        int[] A = new int[]{3,2};
        int out= solve(A);
        System.out.println(out);
    }

    public static int solve1(int[] A) {

        // Try to think when will the unique answer exists,
        //Unique answer only exists when the elements first decreses and then increases.
        // Check is first or last element is the answer.

        int n = A.length;

        //base cases
        if(n==1) return A[0];
        if(A[1] <= A[0]) return A[0];
        if(A[n-1]>=A[n-2]) return A[n-1];

        int low = 1 , high = n - 2;
        while(low <= high)
        {
            int mid = (high - low)/2 + low;

            if(A[mid] >= A[mid-1] && A[mid] >= A[mid+1]) return A[mid];
            else if(A[mid] >= A[mid-1]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static int solve(int[] A) {
        int n = A.length;
        int start =0;
        int end = n-1;
        while(start <= end){
            int mid  = start + (end-start)/2;

            if ((n==1) ||(mid == 0 && A[mid+1] <= A[mid]) || (mid == n-1 && A[mid-1] <= A[mid])){
                return A[mid];
            }

            if((mid!= 0 && A[mid] >= A[mid-1]) && (mid!=n-1 && A[mid] >= A[mid+1])){
                return A[mid];
            }

            if( (mid+1 <= n-1) && (A[mid+1] >= A[mid])){
                start = mid+1;
            }else if((mid-1 >= 0) && (A[mid-1] >= A[mid])){
                end =mid -1;
            }
        }
        return -1;
    }

}
