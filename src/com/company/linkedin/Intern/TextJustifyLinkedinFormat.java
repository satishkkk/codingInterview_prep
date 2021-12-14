package com.company.linkedin.Intern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustifyLinkedinFormat {

    public static String justify(int lineLength, String input){
        StringBuilder out = new StringBuilder();
        List<String> stringList = Arrays.asList(input.split("\\s+"));
        List<String> result = new ArrayList<>();

        int left =0;

        while(left< stringList.size()){
            int right = getRightIndex(left,stringList,lineLength); // get right index
            result.add(beautify(left, right, stringList, lineLength));// modify current string
            left = right+1;
        }
        for(int i=0;i<result.size();i++){
            out.append(result.get(i));
            if(i<result.size()-1)  out.append("\n");
        }
        return out.toString();
    }

    static int getRightIndex(int leftIndex,List<String> stringList,int maxLength){
        int rightIndex = leftIndex;
        int currentlength = stringList.get(rightIndex++).length();
        while(rightIndex<stringList.size() && (currentlength+1+stringList.get(rightIndex).length()) <= maxLength){
            currentlength+= 1+stringList.get(rightIndex).length();
            rightIndex++;
        }
        return rightIndex-1;
    }

    private static String beautify(int left, int right, List<String> words, int maxWidth) {
//        if (right - left == 0) return padResult(words.get(left), maxWidth);
        boolean isLastLine = false;
        if(right == words.size() - 1) isLastLine=true;

        int numSpaces = right - left;//get number of spaces between the words
        int totalSpace = maxWidth - wordsLength(left, right, words);// get number of character we have

        int length =totalSpace / numSpaces;
        String space = isLastLine ? " " : new String(new char[length]).replace('\0', ' ');

        int remainder = isLastLine ? 0 : totalSpace % numSpaces;

        StringBuilder result = new StringBuilder();
        for (int i = left; i <= right; i++)
            result.append(words.get(i))
                    .append(space)
                    .append(remainder-- > 0 ? " " : "");

        return result.toString().trim();
    }


    private static int wordsLength(int left, int right, List<String> words) {
        int wordsLength = 0;
        for (int i = left; i <= right; i++) wordsLength += words.get(i).length();
        return wordsLength;
    }

//     static String padResult(String result, int maxWidth) {
//        return result + blank(maxWidth - result.length());
//    }
//
//    static String blank(int length) {
//        return new String(new char[length]).replace('\0', ' ');
//    }

    public static void main(String[] args) {
        String out =justify(25,"ThIS IS SATISH KATHIRIYA12 GREETING FROM USA, HELLO12");
        System.out.println(out);
    }
}
