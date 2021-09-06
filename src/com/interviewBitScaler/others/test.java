package com.interviewBitScaler.others;

public class test {
    public static void main(String[] args) {
        System.out.println(solution("><><"));

    }
    public static int solution(String S) {
        // write your code in Java SE 8
        int n =S.length();
        char[] charArray = S.toCharArray();
        boolean[] spaceOccupied = new boolean[n];
        for(int i=0;i<n;i++){
            spaceOccupied[i]=true;
        }
        int ans =0;
        for(int i=0;i<n;i++){

            if(charArray[i] == '>'  ){
                if((i+1<n && spaceOccupied[i+1] == false) || i==n-1 ){
                    ans++;
                    if (i+1<n) spaceOccupied[i+1]=false;
                    else spaceOccupied[i]=false;
                }

            }else if(charArray[i] == '<'  ){
                if(( (i-1>=0) && spaceOccupied[i-1] == false) || i==0) {
                    ans++;
                    if (i - 1 > 0) spaceOccupied[i - 1] = false;
                    else spaceOccupied[i] = false;
                }
            }else if(charArray[i] == '^' ||  charArray[i] == 'v' ){
                ans++;
                spaceOccupied[i]=false;
            }
        }
        return ans;
    }
}
