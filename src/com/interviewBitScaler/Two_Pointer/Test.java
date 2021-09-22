package com.interviewBitScaler.Two_Pointer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
//    public static void main(String[] args) {
//
//        int a[][] = new int[2][3];
//        a[0] = new int[]{1,0,0};
//        a[1] = new int[]{2,0,0};
//
//        System.out.println(Maximum_Product(a));
//    }

    static long Maximum_Product(int[][] ar){
        // write your code here
        int n = ar.length;
        int m = ar[0].length;
        int mod = (1000*1000*1000)+7;
        long ans= -1;
        int allZero =1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(ar[i][j]!=0){
                    allZero=0;
                }
            }
        }

        if(allZero==1){
            return 0;
        }

        for(int i=0;i<n;i++){
            int count = 0;
            long p = 1;
            for(int j=0;j<m;j++){

                    if(ar[i][j]==0){
                        count++;
                    }
                    else if(count < m){
                        p = (1l*(p%mod)*(ar[i][j]%mod))%mod;
                    }

            }
            ans= Math.max(ans,p);
        }
        return (int)ans;
    }

    public static void main(String args[] ) throws Exception {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] str = br.readLine().split(" ");
//        int N=Integer.parseInt(str[0]);
//        int X = Integer.parseInt(str[1]);
//        long K = Long.parseLong(str[2]);
//
//        String S = br.readLine();

        int N=200;
        int X = 2;
        long K = 20;

        String S = "21212121222222222222222222221111111111111111112222222222222222221212121212121212121212222222222222222222222111111111121222222222221222222222222221211111111122222222222222222222222221111111111111111111"; //[12345 , 67891 ]
        String  out = Find_It(X,K,S,N);
        StringBuilder s = new StringBuilder();


        System.out.println(out);
    }

    static String Find_It(int X, long K, String S, int N){
        int partition = (N%X ==0) ? N/X : (N/X)+1; // number of partition OR length of output String
        List<String> list = new ArrayList<>();

        int i=0;

        int[] possibility = new int[partition];
        for(int j=0;j<partition;j++){
            String subs = (j==partition-1) ? S.substring(i,S.length()) : S.substring(i,i+X);
            list.add(sortString(subs));
            i=i+X;
            possibility[j]=subs.length();
        }

        long[] suffixPossibility = new long[partition];
        suffixPossibility[partition-1]=1;
        for( int z=possibility.length-2; z>=0; z--){
            suffixPossibility[z] = possibility[z+1]*suffixPossibility[z+1];
        }


        StringBuilder answer = new StringBuilder();

        for(i=0;i<partition;i++){
                long index = K%suffixPossibility[i] == 0 ?(K/suffixPossibility[i])-1 :(K/suffixPossibility[i]);
                answer.append(list.get(i).charAt( (int)(index) ) );
                K -=( (index) * suffixPossibility[i]);
        }
        return answer.toString();
    }

    public static String sortString(String subs){
        char[] ch = subs.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }

}
