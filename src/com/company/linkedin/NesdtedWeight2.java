//package com.company.linkedin;
//
//public class NesdtedWeight2 {
////The idea is to deduct number depth - level times.
////For example, 1x + 2y + 3z = (3 + 1) * (x + y + z) - (3x + 2y + z);
//    public int depthSumInverse(List<NestedInteger> nestedList) {
//        int depthSum = dfs(nestedList, 1);
//        return flatSum * (max + 1) - depthSum;
//    }
//
//    int flatSum = 0;
//    int max = 1;
//    private int dfs(List<NestedInteger> input, int depth) {
//        if (input == null || input.size() == 0) return 0;
//        int sum = 0;
//        for (NestedInteger i : input) {
//            if (i.isInteger()) {
//                max = Math.max(depth, max);
//                sum += i.getInteger() * depth;
//                flatSum += i.getInteger();
//            } else {
//                sum += dfs(i.getList(), depth + 1);
//            }
//        }
//        return sum;
//    }
//
////-----2 pass --------
//
//    public int depthSumInverse(List<NestedInteger> nestedList) {
//        int maxDepth = findMaxDepth(nestedList);
//        return weightedSum(nestedList, 1, maxDepth);
//    }
//
//    private int findMaxDepth(List<NestedInteger> list) {
//        int maxDepth = 1;
//
//        for (NestedInteger nested : list) {
//            if (!nested.isInteger()) {
//                maxDepth = Math.max(maxDepth, 1 + findMaxDepth(nested.getList()));
//            }
//        }
//
//        return maxDepth;
//    }
//
//    private int weightedSum(List<NestedInteger> list, int depth, int maxDepth) {
//        int answer = 0;
//        for (NestedInteger nested : list) {
//            if (nested.isInteger()) {
//                answer += nested.getInteger() * (maxDepth - depth + 1);
//            } else {
//                answer += weightedSum(nested.getList(), depth + 1, maxDepth);
//            }
//        }
//        return answer;
//    }
//}
