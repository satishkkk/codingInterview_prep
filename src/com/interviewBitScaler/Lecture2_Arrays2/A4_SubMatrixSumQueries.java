package com.interviewBitScaler.Lecture2_Arrays2;

public class A4_SubMatrixSumQueries {
    public static void main(String[] args) {

        int[][] A= new int[3][3];
        A[0] = new int[]{1,2,3};
        A[1] = new int[]{4,5,6};
        A[2] = new int[]{7,8,9};
        int[] B = {1,2};
        int[] C = {1,2};
        int[] D = {2,3};
        int[] E = {2,3};
        solve1(A,B,C,D,E);
    }

    public static int[] solve1(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int n=A.length, m = A[0].length, mod = 1000000007;
        int sum=0;
        long preSum[][] = new long[n+1][m+1];

        //preSum[i][j] denotes the sum of elements of matirx (0, 0) to (i, j)
        for(int i = 1; i <= n ; i++)
        {
            for(int j=1;j<=m;j++)
            {
                preSum[i][j] = (A[i-1][j-1] + preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1] + mod)%mod;
            }
        }

        int res[] = new int[B.length];

        for(int i=0;i<B.length;i++)
        {
            int x1=B[i],y1=C[i],x2=D[i],y2=E[i];

            long ans=preSum[x2][y2]-preSum[x2][y1-1]-preSum[x1-1][y2]+preSum[x1-1][y1-1];

            while(ans<0)
                ans+=mod;

            ans=ans%mod;
            res[i] = (int)ans;
        }

        return res;
    }
    public static int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {

        int[] out = new int[B.length];
        int n =A.length;
        int m= A[0].length;
        long[][] sum= new long[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i-1>= 0 && j-1>=0){
                    sum[i][j] =sum[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1]+A[i][j];
                }else if(i==0 && j==0){
                    sum[i][j] = A[i][j];
                }else if(j-1 >= 0){
                    sum[i][j] += sum[i][j-1]+A[i][j];
                }else if(i-1 >= 0){
                    sum[i][j] += sum[i-1][j]+A[i][j];
                }
            }
        }

        for(int i=0 ;i < B.length;i++){
            int b = B[i]-1;
            int c = C[i]-1;
            int d = D[i]-1;
            int e = E[i]-1;

            long ans;
            ans = sum[d][e];
                    //-A[d][c-1] - A[b-1][e] + A[b-1][c-1];
            if(c-1 >=0)
                ans -= sum[d][c-1];

            if(b-1 >=0)
                ans -= sum[b-1][e];

            if(b-1 >=0 && c-1 >= 0)
                ans +=  sum[b-1][c-1];

            ans = (long)(ans % (Math.pow(10,9)+7));

            if(ans < 0)
                ans = (long)(ans +(Math.pow(10,9)+7));
            out[i] = (int)ans;
        }
        return out;
    }

}
