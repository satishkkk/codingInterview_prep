package com.interviewBitScaler.Two_Pointer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class goldenRatio {
    public static void main(String[] args) {
        String sarray[] = new String[]{"1","1.618","1.6181","2.617924","10","4"};

        Set<BigDecimal> set= new HashSet<>();
//        x/y=1.618
        BigDecimal gr = new BigDecimal("1.618");
        for(String s : sarray){
            BigDecimal found = gr.divide(new BigDecimal(s),6, RoundingMode.HALF_UP);
            found.stripTrailingZeros();
            if(set.contains(found)) {
                System.out.println(s);
                System.out.println(found);
            }else{
                set.add(new BigDecimal(s).setScale(6, BigDecimal.ROUND_HALF_UP));
            }

        }
    }
}
