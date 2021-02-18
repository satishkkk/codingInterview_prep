package com.interviewBitScaler.Lecture2_Arrays2;

public class A1_SearchInSOrted2DMatrix {
    //Start from top right corner
    public static void main(String[] args) {
        int[][] A = new int[2][4];

//        int k=0;
//        for(int i=0;i<A.length;i++){
//            int k=1;
//            for(int j =0 ;j<A[0].length;j++){
//                A[i][j] = i+j+k;
//                k++;
//            }
//        }

        A[0] = new int[]{1,3,9,9};
        A[1] = new int[]{2,4,10,10};
        int B =9;
        System.out.println(solve(A,B));
    }


//    TIME : O(N+M)
    public static int solve(int[][] A, int B) {
        int x=-1;
        int y=-1;
        int found =0 ;

        int row = 0;
        int column;

        while(row<A.length){
            column = A[0].length-1;
            while (column>=0){
                if(A[row][column] > B){
                    column--;
                }else if(A[row][column] < B){
                    if(found==1){
                        break;
                    }
                    row++;
                    break;
                }else if(A[row][column]==B){
                    x=row;
                    y=column;
                    column--;
                    found=1;
                }
            }
            if(found==1){
                break;
            }
        }
        if(x==-1 && y==-1){
            return -1;
        }
        x++;
        y++;
        return x*1009 +y;
    }
}
