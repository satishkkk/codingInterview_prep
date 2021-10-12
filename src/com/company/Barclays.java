package com.company;

import java.util.*;

public class Barclays {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,1,2,2,3,3));
        countPairs(list,1);
        Map<Character,Integer> map = new HashMap<>();

        countHighlyProfitableMonths(new ArrayList<>(Arrays.asList(1,2,3,3,4,5)),3);
    }

    public static int countPairs(List<Integer> numbers, int k) {
        // Write your code here
        Set<Integer> setOfNumbers = new HashSet<>();
        Set<Pair> setOfPair = new HashSet<>();

        for(Integer number : numbers){
            setOfNumbers.add(number);
        }

        for(Integer number : numbers){
            if(setOfNumbers.contains(number+k)){
                setOfPair.add(new Pair(number,number+k));
            }
        }

//        setOfPair.removeIf((o1,o2) -> o1==o2);
        return setOfPair.size();

    }

//    public static int countHighlyProfitableMonths(List<Integer> stockPrices, int k) {
//        // Write your code here
//
//        int n = stockPrices.size();
//        int ans=0;
//
//        for(int i=0;i<=n-k;i++){
//            boolean isValid = true;
//            for(int j=i+1;j<i+k;j++){
//                if(stockPrices.get(j) > stockPrices.get(i)) {
//                    continue;
//                }else{
//                    isValid = false;
//                }
//            }
//            if(isValid){
//                ans++;
//            }
//        }
//        return ans;
//    }



    public static int countHighlyProfitableMonths(List<Integer> stockPrices, int k) {
        // Write your code here

        int n = stockPrices.size();
        int ans=0;

        int left =0;

        for(int right=1;right<n;right++){

            if(stockPrices.get(left) < stockPrices.get(right) && right-left +1 <=k){
                if(right-left == k){
                    ans++;
                    left++;
                }
                right++;
            }else if(stockPrices.get(left) > stockPrices.get(right) && left <= n-k){
                left++;
            }


        }


        // for(int i=0;i<=n-k;i++){
        //     boolean isValid = true;
        //     for(int j=i+1;j<i+k;j++){
        //         if(stockPrices.get(j) > stockPrices.get(j-1)) {
        //             continue;
        //         }else{
        //             isValid = false;
        //         }
        //     }
        //     if(isValid){
        //         ans++;
        //     }
        // }

        return ans;
    }
    public static class Pair{
        int i;
        int j;

        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return i == pair.i && j == pair.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}
