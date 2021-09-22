package com.company.samsara;

import java.util.ArrayList;
import java.util.Collections;

public class TwoD_ArrayDiagonalTravrse {
    public static void main(String[] args) {
        findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

    public static int[] findDiagonalOrder(int[][] mat) {

        if(mat == null || mat.length ==0 ){
            return new int[0];
        }

        int n = mat.length;
        int m = mat[0].length;

        int[] result = new int[n*m];
        int k=0;

        ArrayList<Integer> intermediate = new ArrayList<Integer>();

        int row=0;
        boolean reverse = true;
        for(int col=0;col<m;col++){
            intermediate.clear();
            int intercol = col;
            while ( intercol >= 0 && row < n ){
                intermediate.add(mat[row++][intercol--]);
            }
            row=0;
            if(reverse){
                Collections.reverse(intermediate);
            }
            reverse = !reverse;
            for(int i=0;i<intermediate.size();i++){
                result[k++] = intermediate.get(i);
            }
        }

        int col = m-1;
        for( row=1;row<n;row++){
            intermediate.clear();
            int interrow = row;
            while ( col >= 0 && interrow < n ){
                intermediate.add(mat[interrow++][col--]);
            }
            col = m-1;
            if(reverse){
                Collections.reverse(intermediate);
            }
            reverse = !reverse;
            for(int i=0;i<intermediate.size();i++){
                result[k++] = intermediate.get(i);
            }
        }
        return result;
    }
}
