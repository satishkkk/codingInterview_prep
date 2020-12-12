package com.coding.codingninja.codechef.inputOutputHussainset;

import java.io.IOException;
import java.util.*;

public class hussainSet_COOK82C_usingFAstScannner {
    static int max=63000005;
    static long [] ans;

    public static void main(String[] args) throws IOException {
        FastScanner sc=new FastScanner();
        int n=sc.nextInt();
        int m=sc.nextInt();

        long [] a=sc.nextLongArray(n);
        ans=new long[max];
        int [] qu=sc.nextIntArray(m);

        StringBuilder sb=new StringBuilder("");

        Queue<Long> p=new LinkedList<>();
        Queue<Long> q=new LinkedList<>();

        Arrays.sort(a);

        for(int i=n-1;i>=0;i--)p.add(a[i]);

        for(int i=1;i<max;i++){
            if(q.isEmpty()){
                ans[i]=p.poll();
                q.add(ans[i]/2);
            }
            else if(p.isEmpty()){
                ans[i]=q.poll();
                q.add(ans[i]/2);
            }
            else if (!p.isEmpty() && !q.isEmpty()){
                if(p.peek()>q.peek()){
                    ans[i]=p.poll();
                    q.add(ans[i]/2);
                }else{
                    ans[i]=q.poll();
                    q.add(ans[i]/2);
                }
            }
        }

        for(int i=0;i<m;i++){
            sb.append(ans[qu[i]]+"\n");
        }

        System.out.println(sb.toString().trim());

    }
}

/*
*
* https://www.codechef.com/problems/COOK82C
Input:
4 6
8 5 3 1
1
2
3
4
6
8

Output:
8
5
4
3
2
1
*
* */
