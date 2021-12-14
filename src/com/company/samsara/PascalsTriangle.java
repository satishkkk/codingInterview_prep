package com.company.samsara;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        List<List<Integer>> ans = generate(4);
        ans.stream()
                .flatMap(s -> s.stream())
                .forEach(System.out::println);

    }

//  1
//  1 1
//  1 2 1
//  1 3 3 1

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>( Arrays.asList(1) ));

        for(int row =1; row < numRows;row++){
            List<Integer> currentRow = new ArrayList<>();
            List<Integer> previousRow = ans.get(row-1);

            currentRow.add(previousRow.get(0));

            for(int j=1;j<row;j++){
                currentRow.add(previousRow.get(j-1)+previousRow.get(j));
            }
            currentRow.add(1);
            ans.add(currentRow);
        }
        return ans;
    }
}
