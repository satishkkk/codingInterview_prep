package com.company.Goldman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class goldman2 {

    public static int requiredAmountAtStart(List<Integer> netSaving) {
        int sum=0;
        int answer=0;
        for(int i=0;i<netSaving.size();i++){

            if(netSaving.get(i)>0){
                sum= netSaving.get(i)+sum;
            }
            if(netSaving.get(i)<0){
                if(sum<0){
                    sum=0;
                }
                sum=sum-Math.abs(netSaving.get(i));

                if(sum<0){
                    answer=answer+Math.abs(sum);
                    answer++;
                    sum=1;
                }

            }
        }
        return answer;
    }

    public static void main(String args[]){
        //1,-2,-3,10,-2,4
        //2,-3,1,-2
        //3,1,2,-4,-5
        List<Integer> netProfit = Arrays.asList(3,1,2,-4,-5);

        List<Integer> test = new ArrayList<>();
        test.add(1);

        Integer Answer = requiredAmountAtStart(netProfit);
        System.out.println(Answer);
    }
}
