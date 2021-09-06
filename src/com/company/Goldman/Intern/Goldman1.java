package com.company.Goldman.Intern;

import java.util.*;

public class Goldman1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(3,1,7,2,4));
        long process = 15;
        System.out.println(minimumTime(list,process));
    }

    public static int minimumTime1(List<Integer> ability, long processes) {
        // Write your code here
        int ans =0;
        while(processes>0){
            ability.sort( (a,b) -> b-a);
            processes = processes - ability.get(0);
            ability.add((int)Math.floor(ability.get(0)/2));
            ability.remove(0);
            ans++;
        }
        return ans;
    }

    public static int minimumTime(List<Integer> ability, long processes) {
        // Write your code here
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> b-a);

        for(Integer i:ability){
            maxHeap.add(i);
        }
        int time =0;
        while(processes>0){
            int maxCapacity =  maxHeap.peek();
            processes = processes - maxCapacity;
            maxHeap.remove();
            maxHeap.add((int)Math.floor(maxCapacity/2));
            time++;
        }
        return time;
    }

}
