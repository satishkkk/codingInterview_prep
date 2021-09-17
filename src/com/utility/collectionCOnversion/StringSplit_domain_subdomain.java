package com.utility.collectionCOnversion;

import java.util.*;

public class StringSplit_domain_subdomain {
    public static void main(String[] args) {
//        Map<String ,Integer> map = new HashMap<String ,Integer>();
//        map.put("abc.com",2);
//        map.put("xyz.abc.com",3);
//        map.put("info.xyz.abc.com",1);
//        map.put("info.xyz.def.com",6);
//        map.put("info.xyz.jkl.com",2);
//        map.put("info.xyz.def.com",5);

        List<String> list = new ArrayList<>(Arrays.asList("abc.com 2", "xyz.abc.com 3", "info.xyz.abc.com 1",
                "info.xyz.def.com 6", "info.xyz.jkl.com 2","info.xyz.def.com 5" ));

        Map<String ,Integer> ans = new HashMap<String ,Integer>();
        for(String s : list){
            String[] domainFrequencyPair = s.split("\\s+"); // 0 -domain name & 1 - frequency
            String[] domainList = domainFrequencyPair[0].split("\\."); // split domain - last two will be domain
            int n = domainList.length;
            if(n>=2){
                String domainName= domainList[n-2]+"."+domainList[n-1];
                ans.put(domainName,ans.getOrDefault(domainName,0)+Integer.parseInt(domainFrequencyPair[1]));
            }
        }
        System.out.println("Hello");

    }
}
