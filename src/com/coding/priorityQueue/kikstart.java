package com.coding.priorityQueue;

import java.util.*;

public class kikstart {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while(testCase>0){
            int numberOfPeople = sc.nextInt();
            int maxAmount = sc.nextInt();
            List<Integer> listOFWithdrawAmount = new ArrayList<>();
            while(numberOfPeople>0){
                listOFWithdrawAmount.add(sc.nextInt());
                numberOfPeople--;
            }
            priorityQueueImpl(maxAmount,listOFWithdrawAmount);
            testCase--;
        }

    }

    static void priorityQueueImpl(int maxAmount,List<Integer> listOFWithdrawAmount){
        System.out.println(listOFWithdrawAmount.toString());
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(new ByAmount(maxAmount));

        for(int i=0; i<listOFWithdrawAmount.size();i++){
            pQueue.add(listOFWithdrawAmount.get(i));
        }
        System.out.println(pQueue.toString());
//        while(!pQueue.isEmpty()){
//            System.out.println(pQueue.poll());
//        }

        while(!pQueue.isEmpty()){
            System.out.println(listOFWithdrawAmount.indexOf(pQueue.poll())+1);
        }

    }

}
class ByAmount implements Comparator<Integer>{
    int maxAmount;

    ByAmount(int maxAmount){
        this.maxAmount=maxAmount;
    }

    @Override
    public int compare(Integer I1, Integer I2){
        return Integer.compare(I1/maxAmount,I2/maxAmount);
//        return (c==0) ? c : Integer.compare(I1%maxAmount,I2%maxAmount);
    }
}

