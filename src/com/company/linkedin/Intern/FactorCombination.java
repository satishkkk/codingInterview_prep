package com.company.linkedin.Intern;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FactorCombination {

//    TC O(N)
    public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), n, 2);
        return result;
    }

    public static void helper(List<List<Integer>> result, List<Integer> item, int n, int start) {
        if (n <= 1) {
            if (item.size() > 1) {
                result.add(new ArrayList<Integer>(item));
            }
            return;
        }

        for (int i = start; i <= n; ++i) {
            if (n % i == 0) {
                item.add(i);
                helper(result, item, n / i, i);
                item.remove(item.size() - 1);
            }
        }
//        int i = n; // ===> here, change 2
//        item.add(i);
//        helper(result,item,n/i, i );
//        item.remove(item.size()-1);
    }

//    TC : O(log N)
    private static void getFactors(int start, int n, List<Integer> path, List<List<Integer>> ret){
        for(int i = start; i <= Math.sqrt(n); i++){
            if(n % i == 0 && n/i >= i){  // The previous factor is no bigger than the next
                path.add(i);
                path.add(n/i);
                ret.add(new LinkedList<Integer>(path));
                path.remove(path.size() - 1);
                getFactors(i, n/i, path, ret);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> out = getFactors(12);
        System.out.println(out);
    }
//    public static List<List<Integer>> getFactors(int n) {
//        List<List<Integer>> ret = new LinkedList<List<Integer>>();
//        if(n <= 3)  return ret;
//        List<Integer> path = new LinkedList<Integer>();
//        getFactors(2, n, path, ret);
//        return ret;
//    }

//
//

//    }
}
