package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args)  {
        String s = "ggogle.com.co";
        String [] k = s.split("\\.",1);

        typosquats(new ArrayList<>(Arrays.asList("palantir.com",
                        "nic.cl")),
                new ArrayList<>(Arrays.asList("paiantir.com" ,
                        "nic.ci" ,
                        "palantirtechnologies.com" ,
                        "nlc.biz")));
    }

    public static List<String> typosquats(List<String> companyDomains, List<String> newDomains) {

//        List<String> ans = new ArrayList<>();
        Set<String> ans = new HashSet<>();
        Map<String,String> domainMapper = new HashMap<>();

        List<Set<Character>> listOfTypo = new ArrayList<>();
        listOfTypo.add(new HashSet<>(Arrays.asList('1', 'i', 'l', '!', '|')));
        listOfTypo.add(new HashSet<>(Arrays.asList('s', '5', '$')));
        listOfTypo.add(new HashSet<>(Arrays.asList('o', '0')));
        listOfTypo.add(new HashSet<>(Arrays.asList('a','@')));
        listOfTypo.add(new HashSet<>(Arrays.asList('e','3')));

        for(String domainName : companyDomains){
            String[] s = domainName.split("\\.",2);
            domainMapper.put(s[0], s[1]);
        }

        for(String typo : newDomains){
            for(String og: companyDomains){
                if(checktypo(og,typo,listOfTypo)) ans.add(typo);
            }
        }
        for(String typo : newDomains){
            String[] s = typo.split("\\.",2);
            if(domainMapper.containsKey(s[0]) && !domainMapper.get(s[0]).equals(s[1])){
                String originalMatched = s[0]+"."+domainMapper.get(s[0]);
                if(!typo.equals(originalMatched)){
                    if(!companyDomains.contains(typo) && checktypo(originalMatched,typo,listOfTypo))
                        ans.add(typo);
                }
            }
        }

        return ans.stream().collect(Collectors.toList());
    }

    public static boolean checktypo(String original,String Typo, List<Set<Character>> listOfTypo){

        int n = Typo.length();
        int m = original.length();

        if(n==m){
            for(int i=0;i<n && i<m;i++){
                if(original.charAt(i) != Typo.charAt(i)){
                    for(Set<Character> set : listOfTypo){
                        if(set.contains(Typo.charAt(i))){
                            for(Character ch : set){
                                if(ch == Typo.charAt(i)){
                                    return true;
                                }
                            }
                        };
                    }
                }
            }
        }

        return false;
    }


}

