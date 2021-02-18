package com.interviewBitScaler.Lecture2_Arrays2;

public class A5_SumOFAllSubMatrix {
    static int matrixSum(int A[][])
    {
        int n = A.length;
        int sum = 0;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                // Number of ways to choose
                // from top-left elements
                int top_left = (i + 1) * (j + 1);

                // Number of ways to choose
                // from bottom-right elements
                int bottom_right = (n - i) * (n - j);
                sum += (top_left * bottom_right * A[i][j]);
            }
        }

        return sum;
    }
    // Driver Code
    public static void main(String[] args)
    {
        int arr[][] = {{1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}};

        System.out.println(matrixSum(arr));
    }
}
