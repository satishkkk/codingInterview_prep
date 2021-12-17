package com.interviewBitScaler.Lecture2_Arrays2;
public class WordSearchIn2DArray {

    public static void main(String[] args) {
        char[][] board = new char [][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        System.out.println(exist(board,word));
    }
    public static boolean exist(char[][] board, String word) {
        int[] horizontal = new int[]{1,0,-1,0};
        int[] vertical = new int[]{0,1,0,-1};

        return utility(board,word,horizontal,vertical,0,0,0);
    }

    public static boolean utility(char[][] board, String word,int[] horizontal,int[] vertical,int index,int rowIndex,int colIndex){

        if(!isValid(board,rowIndex,colIndex,word,index)){
            return false;
        }

        if(index == word.length()-1 && word.charAt(index)== board[rowIndex][colIndex])
            return true;

        for(int i=rowIndex;i<board.length;i++ ){
            for(int j= colIndex ;j<board[0].length;j++){
                if(board[i][j] == word.charAt(index)){
                    return utility(board,word,horizontal,vertical,index+1,rowIndex+horizontal[0],colIndex+vertical[0])||
                            utility(board,word,horizontal,vertical,index+1,rowIndex+horizontal[1],colIndex+vertical[1])||
                            utility(board,word,horizontal,vertical,index+1,rowIndex+horizontal[2],colIndex+vertical[2])||
                            utility(board,word,horizontal,vertical,index+1,rowIndex+horizontal[3],colIndex+vertical[3]);
                }
            }
        }
        return false;
    }

    static boolean isValid(char[][] board,int rowIndex,int colIndex,String word, int index){
        if(rowIndex < board.length && colIndex <board[0].length && word.charAt(index) == board[rowIndex][colIndex]) return true;
        return false;
    }

}