package com.company.Goldman;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class goldman1 {

    // Complete the countSubSequence function below.
    static int countSubSequence(List<Integer> inputSeq, int targetSum) {
        Integer totalCount=0;
        for(int i=0;i<inputSeq.size();i++){
            int current=inputSeq.get(i);
            if(current==targetSum){
                totalCount++;
                continue;
            }
            int pending=targetSum;
            for (int j=i;pending>0 && j<inputSeq.size();j++){
                current=inputSeq.get(j);
                pending = pending-current;
                if(pending==0){
                    totalCount++;
                    break;
                }
            }
        }
        return totalCount;
    }
    public static void main(String[] args) throws IOException {
        List<Integer> netProfit = Arrays.asList(3,1,2,5,6);
        int targetSum= 6;
        int totalCount =countSubSequence(netProfit,targetSum);
        System.out.println(totalCount);
    }
}
