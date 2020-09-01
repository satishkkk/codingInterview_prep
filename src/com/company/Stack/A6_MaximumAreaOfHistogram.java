package com.company.Stack;

import java.util.*;

class Histogram{
    int height;
    int index;

    Histogram(int height , int index){
        this.height = height;
        this.index = index;
    }
    public int getHeight() {
        return height;
    }

    public int getIndex() {
        return index;
    }

}


public class A6_MaximumAreaOfHistogram {

    public int[] nearestSmallestIndexToLeft(int[] in ){
        Stack<Histogram> s = new Stack<>();
        List<Integer> out = new ArrayList<>();

        for(int i=0;i<in.length;i++){
            if(s.isEmpty())
                out.add(-1);
            else if(!s.isEmpty() && in[i] > s.peek().getHeight())
                out.add(s.peek().getIndex());
            else{
                while(!s.isEmpty() && in[i] < s.peek().getHeight()){
                    s.pop();
                }
                if(s.isEmpty())
                    out.add(-1);
                else if(!s.isEmpty() && in[i] > s.peek().getHeight())
                    out.add(s.peek().getIndex());
            }
            s.push(new Histogram(in[i],i));
        }
        return out.stream().mapToInt(i->i).toArray();
    }

    public int[] nearestSmallestIndexToRight(int[] in ){
        Stack<Histogram> s = new Stack<>();
        List<Integer> out = new ArrayList<>();

        for(int i=in.length-1;i>=0;i--){
            if(s.isEmpty())
                out.add(in.length);
            else if(!s.isEmpty() && in[i] > s.peek().getHeight())
                out.add(s.peek().getIndex());
            else{
                while(!s.isEmpty() && in[i] < s.peek().getHeight()){
                    s.pop();
                }
                if(!s.isEmpty() && in[i] > s.peek().getHeight())
                    out.add(s.peek().getIndex());
                else if(s.isEmpty())
                    out.add(in.length);
            }
            s.push(new Histogram(in[i],i));
        }
        Collections.reverse(out);
        return out.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] in = new int[]{2,1,5,6,2,3};
        Integer[] out = new Integer[in.length];

        A6_MaximumAreaOfHistogram NS = new A6_MaximumAreaOfHistogram();
        int[] smallesttoLeftIndex =  NS.nearestSmallestIndexToLeft(in);
        int[] smallesttoRightIndex =  NS.nearestSmallestIndexToRight(in);
        for(int i =0 ;i<in.length;i++){
            out[i]= in[i]*(smallesttoRightIndex[i]- smallesttoLeftIndex[i]-1);
        }


        System.out.println( Collections.max(Arrays.asList(out)));
//        for(int i=0;i<out.length;i++)
//            System.out.println(out[i]);
//        Arrays.asList(out).forEach(n -> System.out.println(n));
    }
}
