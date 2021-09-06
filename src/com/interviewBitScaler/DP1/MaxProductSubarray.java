package com.interviewBitScaler.DP1;

public class MaxProductSubarray {
    public static void main(String[] args) {
        int[] A =new int[] { 0, 0, 0, 3, 3, 0, 0};
        System.out.println(maxProduct(A));
    }

    public static int maxProduct(final int[] A) {
        if(A.length==0) return 0;

        int maxSofar = A[0];
        int minSofar = A[0];

        int ans= A[0];
        for(int i=1;i<A.length;i++){
            if(A[i]==0){
                ans = Math.max(ans,0);
                maxSofar=1;
                minSofar=1;
                continue;
            }
            int temp = maxSofar;
            maxSofar = Math.max(A[i], Math.max(maxSofar*A[i],minSofar*A[i]) );
            minSofar = Math.min(A[i],Math.min(temp*A[i],minSofar*A[i]));

            ans = Math.max(ans,maxSofar);
        }
        return ans;
    }
}
