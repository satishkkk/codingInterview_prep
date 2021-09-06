package com.company.Goldman;

import java.util.*;

public class TwosumUniquePair {

    public static int getUniquePairsOpti(List<Integer> nums, long target){
        Set<Integer> seen =  new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums){

            if (map.containsKey(num)){
                int key = map.get(num)*10 + num;
                if (! seen.contains(key)){
                    ans++;
                    seen.add(key);
                }
            } else {
                map.put((int)target-num, num);
            }

        }
        return ans;

    }

}
