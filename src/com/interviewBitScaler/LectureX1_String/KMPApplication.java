package com.interviewBitScaler.LectureX1_String;


public class KMPApplication {
    public static void main(String[] args) {
        System.out.println(solve("1101111111","1101111111"));
    }

    public static int solve(String A, String B) {

        String text = B+B;
        String pattern = A ;
        return KMPSearch(pattern.toCharArray(),text.toCharArray());
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

    public static int KMPSearch(char[] pattern,char[] text){
        int count =0;
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
                count++;
                j = lps[j-1];
            }
        }
        return count;
    }
}
