// Do not remove these imports. You may add others if you wish.
import java.io.*;
import java.util.*;

public class Test {
    // If you need extra classes, you can define them privately here within class Solution

    /*
      Args:
        weaknesses: a String, one character for each cookie weakness.
        grid: a char[][] describing the map layout, one char per room

      Returns:
        An int, how many time units it will take the Cookie Monster to reach you.
    */
    static int timeToEscape(String weaknesses, char[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        Set<Character> weaknessSet = new HashSet<>();
        for(int i=0;i<weaknesses.length();i++){
            weaknessSet.add(weaknesses.charAt(i));
        }

        int[][] costMatrix= new int[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == '.'){
                    costMatrix[i][j] =1;
                }else if(grid[i][j] == 'M'  ){
                    costMatrix[i][j] =0;
                }else if(grid[i][j] == 'Y'  ){
                    costMatrix[i][j] =1;
                }
                else if(weaknessSet.contains(grid[i][j])){
                    costMatrix[i][j] =5;
                }else{
                    costMatrix[i][j] =2;
                }
            }
        }



        return minPathSum(costMatrix);
    }

    public static int minPathSum(int[][] grid) {
//         System.out.println(grid);

        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    dp[i][j] = grid[i][j] +  dp[i][j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                else if(j != grid[0].length - 1 && i != grid.length - 1){
                    int val=0;
                    if (i >=0 && i< grid.length && i-1 >=0 && i-1 < grid.length && j>=0 && j< grid[0].length && j-1>=0 && j-1 < grid[0].length){
                        val = Math.min(Integer.MAX_VALUE,Math.min(dp[i][j-1],dp[i - 1][j]) );
                    }
                    dp[i][j] = grid[i][j] + Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), val==0 ? Integer.MAX_VALUE : val);
                }
                else
                    dp[i][j] = grid[i][j];
            }
        }
        return dp[0][0];
    }

    // DO NOT MODIFY MAIN()
    public static void main(String[] args) {
        String arg0 = "";
        List<String> input_strings = new ArrayList<String>();

        String line;
        boolean first_arg = true;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while ((line = br.readLine()) != null) {
                if (line.equals("")) {
                    continue;
                }

                if(first_arg) {
                    arg0 = line;
                    first_arg = false;
                } else {
                    input_strings.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        char[][] grid = new char[input_strings.size()][input_strings.get(0).length()];
        for(int i = 0; i < input_strings.size(); i++) {
            grid[i] = input_strings.get(i).toCharArray();
        }

        System.out.println(timeToEscape(arg0, grid));

    }
}
