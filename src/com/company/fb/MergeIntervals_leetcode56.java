package com.company.fb;

import java.util.*;

public class MergeIntervals_leetcode56 {

    public static void main(String[] args) {
        List<String> brand_products = new ArrayList<>();
        brand_products.add("BIg KahunA burgER,B06UMX0BXM");
        brand_products.add("sTARk iNduSTRIeS,B08SLX1MWS");
        brand_products.add("stark INDusTRIES,B05ITC1CSS");
        brand_products.add("wayNe eNTeRPRiseS,B06TSB7VPU");
        brand_products.add("StaRK iNdUsTriEs,B05CCF2UDL");
        brand_products.add("biG kAhUna bURGeR,B06QRL8CYP");
        generate_tpids(brand_products);
    }

    public static List<String> generate_tpids(List<String> brand_products) {
        Set<String> productSet = new HashSet<>();
        Set<String> brandSet = new HashSet<>();
        Map<String,Pair> brandProductCountmap = new HashMap<>();
        List<String> out= new ArrayList<>();

        for(String completeProductName: brand_products){
            String[] completeProductNameArray = completeProductName.split("\\,");
            String uniqueBigProductName = completeProductNameArray[0].toLowerCase()+","+completeProductNameArray[1];//lower case
            if(!productSet.contains(uniqueBigProductName)){
                productSet.add(uniqueBigProductName);// add to set
                String[] productName = uniqueBigProductName.split("\\,");
                String brand = productName[0];
                if(brandProductCountmap.containsKey(brand)){
                    Pair pair = brandProductCountmap.get(brand);
                    pair.productNumber++;
                    String brandNumber = pair.brandNumber.toString();
                    String productNumber = pair.productNumber.toString();
                    String TPID = generateTPID(brandNumber,productNumber);
                    out.add(TPID);
                    brandProductCountmap.put(brand,pair);
                }else{
                    brandSet.add(brand);
                    Pair pair = new Pair(brandSet.size(),1);
                    brandProductCountmap.put(brand,pair);
                    String TPID = generateTPID(String.valueOf(brandSet.size()),"1");
                    out.add(TPID);
                }
            }
        }

        return out;
    }

    public static String generateTPID(String brandNumber,String productNumber){
        int brandNumberSize = brandNumber.length();
        StringBuilder sb = new StringBuilder(brandNumber);
        while(brandNumberSize<3){
            sb.insert(0,"0");
            brandNumberSize++;
        }

        int productNumberSize = productNumber.length();
        StringBuilder sb1 = new StringBuilder(productNumber);
        while(productNumberSize<7){
            sb1.insert(0,"0");
            productNumberSize++;
        }
        return sb.toString()+sb1.toString();
    }
    static class Pair{
        Integer brandNumber;
        Integer productNumber;

        Pair(Integer brandNumber,Integer productNumber){
            this.brandNumber = brandNumber;
            this.productNumber=productNumber;
        }
    }
}
