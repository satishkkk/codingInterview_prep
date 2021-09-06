package com.company.Goldman.Intern;

import java.util.*;

public class Goldman2 {
    public static void main(String[] args) {
        System.out.println(triplets(8,new ArrayList<Integer>(Arrays.asList(1,4,2,6,3))));
//        System.out.println(triplets(12,new ArrayList<Integer>(Arrays.asList(5, 1, 3, 4, 7))));
    }
    static long triplets(long t, List<Integer> d) {
        d.sort((a,b) -> a-b);
        int ans =0 ;
        int n = d.size();

        for (int i = 0; i < n - 2; i++)
        {
            int j = i + 1;
            int k = n - 1;

            while (j < k)
            {
                if (d.get(i) + d.get(j) + d.get(k) > t)
                    k--;
                else
                {
                    for (int x = j + 1; x <= k; x++){
                        ans++;
                    }
                    j++;
                }
            }
        }
        return ans;

    }

    static long triplets1(long t, List<Integer> d) {
        long ans=0;
        d.sort((a,b) -> a-b);
        for(int i=0;i<d.size();i++){
            //create empty array
            ArrayList<Integer> b = new ArrayList<>();
            for(int j=i+1;j<d.size();j++){
                if(d.get(j)>d.get(i)) b.add(d.get(j));
            }
            TreeSet<Integer> treeSet = new TreeSet<>();

            for(int k=0;k<b.size();k++){
                for(Integer element : treeSet){
                    if(element >= b.get(k) || d.get(i)+element+b.get(k) > t) break;
                    ans++;
                }
                treeSet.add(b.get(k));
            }
        }

        return ans;
    }

    static long triplets2(long t, List<Integer> d) {
        long cnt=0;
        int n=d.size();
        d.sort((a,b) -> a-b);

        for(int k=2;k<n;k++)
        {
            TreeMap<Integer,Integer> ts1=new TreeMap<>();
            for(int j=0;j<k;j++)
            {
                if(d.get(j)==d.get(k))
                    break;
                int i=Math.min((int)t-d.get(k)-d.get(j),d.get(j)); //try to get the number of elements less than arr[j] and target-arr[k]-arr[j]
                cnt+=(ts1.lowerKey(i)==null?0:ts1.get(ts1.lowerKey(i)));

                if(ts1.containsKey(d.get(j)))
                    ts1.put(d.get(j),ts1.get(d.get(j))+1);
                else
                {
                    Integer val=ts1.lowerKey(d.get(j));
                    ts1.put(d.get(j),1+(val==null?0:ts1.get(val)));
                }
            }
        }
        return cnt;
    }
}
