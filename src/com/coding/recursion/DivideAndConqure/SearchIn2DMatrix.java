package com.coding.recursion.DivideAndConqure;

class SearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] matrix= new int[][]{
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
//                {-1,3}
        };
        System.out.println( searchMatrix(matrix,20) );
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        return foundInMatrix(matrix,target,0,matrix.length-1,0,matrix[0].length-1);
    }

    public static boolean foundInMatrix(int[][] matrix, int target, int rowStart,int rowEnd, int colStart,int colEnd){

        if( rowStart > rowEnd || colStart > colEnd ) return false;

        int midRow = rowStart + (rowEnd - rowStart)/2;
        int midCol = colStart + (colEnd - colStart )/2;

        int midVal = matrix[midRow][midCol];
        System.out.println(midVal);
        boolean foundinleft=false, foundinright=false;
        if(target == midVal){
            return true;
        }
        else if(target > midVal){
            // discard top left part
            if(midRow+1 <= rowEnd) rowStart = midRow+1;
            if(midCol+1 <= colEnd) colStart = midCol+1;
             foundinleft = foundInMatrix(matrix,target,rowStart,rowEnd,colStart,colEnd);
        }else{
            //discard bottom right part
            if(midRow-1 >= rowStart) rowEnd = midRow-1;
            if(midCol-1 >= colStart) colEnd = midCol-1;
             foundinright = foundInMatrix(matrix,target,rowStart,rowEnd,colStart,colEnd);
        }
        return foundinleft || foundinright;
    }
}