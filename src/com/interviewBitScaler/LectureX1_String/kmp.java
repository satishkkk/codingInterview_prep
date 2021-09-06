package com.interviewBitScaler.LectureX1_String;

public class kmp {
    public static void main(String[] args) {

        String pattern = "aabaaac";
        String text = "aabaaadaabaaacaabaaad";
        KMPSearch(pattern.toCharArray(),text.toCharArray());
    }

    public static void computeLPSArray(char[] pattern,int[] lps){
        int m = pattern.length;

        int len =0;
        int i=1;
        lps[0]=0;

        while(i<m){
            if(pattern[i] == pattern[len]){
                //match
                lps[i] = len+1;
                i++;
                len++;
            }else{
                //mismatch
                if(len!=0){
                    len=lps[len-1]; //very important steps
                }else{
                    //len == 0
                    lps[i]=0;
                    i=i+1;
                }
            }
        }
    }

    public static void KMPSearch(char[] pattern,char[] text){
        int n = text.length;
        int m = pattern.length;

        int[] lps=new int[m];

        computeLPSArray(pattern,lps);

        int i=0; //text
        int j=0; //pattern

        while(i<n){
            if(text[i] == pattern[j]){
                //match
                i++;
                j++;
            }else{
                //mis match
                if(j!=0)
                    j = lps[j-1]; //if mismatch then move j towards lps[j-1]
                else
                    i=i+1;

            }
            if(j==m){
                System.out.println("Start Index:"+ (i-j) +"End Index:"+ (i-1));
                j = lps[j-1];
            }

        }
    }
}
