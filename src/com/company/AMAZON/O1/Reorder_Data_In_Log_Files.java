package com.company.AMAZON.O1;

import java.util.*;

public class Reorder_Data_In_Log_Files {
    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
//        System.out.println( (60-120)%60 );
//        reorderLogFiles(logs);
        String s = mostCommonWord( "a, a, a, a, b,b,b,c, c", new String[]{"a"});
//        String normalizedStr = "asdasd,dasd,da,".replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        System.out.println(s);
    }



    public static String[] reorderLogFiles(String[] logs) {

        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                // split each log into two parts: <identifier, content>
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                // case 1). both logs are letter-logs
                if (!isDigit1 && !isDigit2) {
                    // first compare the content
                    int cmp = split1[1].compareTo(split2[1]);
                    if (cmp != 0)
                        return cmp;
                    // logs of same content, compare the identifiers
                    return split1[0].compareTo(split2[0]);
                }

                // case 2). one of logs is digit-log
                if (!isDigit1 && isDigit2)
                    // the letter-log comes before digit-logs
                    return -1;
                else if (isDigit1 && !isDigit2)
                    return 1;
                else
                    // case 3). both logs are digit-log
                    return 0;
            }
        };

        Arrays.sort(logs, myComp);
        return logs;
    }

    public static String mostCommonWord(String paragraph, String[] banned) {

        Set<String> banendStringSet = new HashSet<String>(Arrays.asList(banned));
        String[] arr = paragraph.split(" ");
        Map<String,Integer> map = new HashMap<>();

        for(int i=0;i< arr.length;i++){
            //remove punctuation
            String cleanString = removePunctuation(arr[i]);
            String word = cleanString.toLowerCase();
            map.put( word, map.getOrDefault(word,0)+1);
        }

        int maxFrequency = Integer.MIN_VALUE;
        String ans="";
        // iterate through array
        for(Map.Entry<String, Integer> pair : map.entrySet()){
            if(!banendStringSet.contains(pair.getKey()) && pair.getValue() > maxFrequency){
                ans = pair.getKey();
                maxFrequency = pair.getValue();
            }
        }
        // update max -> if banned dont consider

        return ans;

    }
    public static String removePunctuation(String s){
        Set<Character> punctuation = new HashSet<Character>(Arrays.asList(',','.','/',';'));
        StringBuilder sb = new StringBuilder(s);
        List<Integer> indexList = new ArrayList<>();
        for(int i=0;i<sb.length();i++){
            if(punctuation.contains(s.charAt(i))){
                indexList.add(i);
            }
        }
        for(int i= indexList.size()-1;i>=0;i--){
            int index = indexList.get(i);
            sb.replace(index,index+1," ");
        }
        return sb.toString();
    }






}
