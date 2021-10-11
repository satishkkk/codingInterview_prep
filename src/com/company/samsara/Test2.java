package com.company.samsara;

public class Test2 {
    public static void main(String[] args) {
//        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
//        minheap.add(1);
//
//        Stack<Integer> stack = new Stack<>();
//       int n =120;
//       int k=2;
//       String s = String.valueOf(n);
//       int length = s.length();
//
//        Set<Integer> ans = new HashSet<>();
//
//       for(int i=0;i<=length-k;i++){
//           String smallerNumberString = s.substring(i,k+i);
//           int smallerNumber = Integer.parseInt(smallerNumberString);
//           if(smallerNumber!=0 && n%smallerNumber == 0) ans.add(smallerNumber);
//       }

        System.out.println(l(new int[]{-1,4,6,2,8,4,7,12},5));
//        System.out.println(ans.size());
    }

//    public static int longestSubarray(int[] A, int limit) {
//        int i = 0, j;
//        TreeMap<Integer, Integer> m = new TreeMap<>();
//        for (j = 0; j < A.length; j++) {
//            m.put(A[j], 1 + m.getOrDefault(A[j], 0));
//            if (m.lastEntry().getKey() - m.firstEntry().getKey() > limit) {
//                m.put(A[i], m.get(A[i]) - 1);
//                if (m.get(A[i]) == 0)
//                    m.remove(A[i]);
//                i++;
//            }
//        }
//        System.out.println(i);
//        System.out.println(j);
//        return j - i;
//    }

    public static int l(int numbers[],int diff){
        int n= numbers.length;
        int l=0;
        int newl=0;
        int newr=0;
        int maxLength=0;
        for(int r=1;r<n;r++){
            if(Math.abs(numbers[r-1]-numbers[r]) <= diff){
                continue;
            }else{
                if(maxLength<r-l){
                    maxLength = r-1;
                    newl = l;
                    newr = r-1;
                }
                l=r;
            }
        }
        System.out.println(newl);
        System.out.println(newr);
        return 0;
    }
}
