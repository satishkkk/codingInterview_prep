package com.company.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class StockPrice{
    int stockPrice;
    int day;

    StockPrice(int stockPrice , int day){
        this.stockPrice = stockPrice;
        this.day = day;
    }
    public int getStockPrice() {
        return stockPrice;
    }

    public int getDay() {
        return day;
    }

}

public class A5_StockSpanProblem {

    /*
    STock span problem : u have given historical stocks price for each days in array .
    Find the number of day for which consecutive stock price which is lower or equal to the current day

    Stock price : 100,80,60,70,60,75,85
    Output :      1,1,1,2,1,4,6

    it looks like find nearedt greter to the left
    find its index and subtract it from current index. . . .
     */

    public int[] stocksSpan (int[] in) {
        Stack<StockPrice> s = new Stack<>();
        List<Integer> indexOfHighPriceDay = new ArrayList<>();

        for(int i=0; i < in.length ;i++){
            if(s.isEmpty()) {
                indexOfHighPriceDay.add(-1);
            }

            else if(!s.isEmpty() && s.peek().getStockPrice() >= in[i]){
                indexOfHighPriceDay.add(s.peek().getDay());
            }

            else if(!s.isEmpty() && s.peek().getStockPrice() <= in[i]){
                while(!s.isEmpty() && s.peek().getStockPrice() <= in[i] ){
                    s.pop();
                }
                if(s.isEmpty())
                    indexOfHighPriceDay.add(-1);
                else if(!s.isEmpty() && s.peek().getStockPrice() >= in[i])
                    indexOfHighPriceDay.add(s.peek().getDay());
            }
            s.push(new StockPrice(in[i],i));
        }

        for(int i=0; i< indexOfHighPriceDay.size();i++){
            indexOfHighPriceDay.set(i , i-indexOfHighPriceDay.get(i) );
        }
        return indexOfHighPriceDay.stream().mapToInt(i -> i).toArray();
    }
    public static void main(String[] args) {
        int[] in = new int[]{100,80,60,70,60,75,85};

        A5_StockSpanProblem GTR = new A5_StockSpanProblem();
        int[] out = GTR.stocksSpan(in);
        for(int i=0;i<out.length;i++)
            System.out.println(out[i]);
//        Arrays.asList(out).forEach(n -> System.out.println(n));
    }
}
