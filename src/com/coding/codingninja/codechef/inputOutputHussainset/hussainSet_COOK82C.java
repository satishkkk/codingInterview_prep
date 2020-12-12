package com.coding.codingninja.codechef.inputOutputHussainset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class hussainSet_COOK82C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
        String ip[] = (br.readLine()).split("\\s+"); // read n and m
        int n = Integer.parseInt(ip[0]), m = Integer.parseInt(ip[1]);

        ip = (br.readLine()).split("\\s+");// read ip array
        ArrayList<Long> v = new ArrayList<>(n);
        for(int i=0; i<n; ++i)
            v.add(Long.parseLong(ip[i]));

        Collections.sort(v);

        ArrayDeque<Long> q = new ArrayDeque<>();

        int count = 0; //global count
        while(m-- > 0)
        {
            int turn = Integer.parseInt(br.readLine());

            long last = 0;
            while(count < turn) // ?
            {
                if(!v.isEmpty() && !q.isEmpty())
                {
                    long vlast = v.get(v.size()-1), qfirst = q.peek();

                    if(vlast > qfirst)
                    {
                        v.remove(v.size()-1);
                        last = vlast;
                    }
                    else
                    {
                        q.poll();
                        last = qfirst;
                    }
                }
                else if(!v.isEmpty())
                {
                    last = v.get(v.size()-1);
                    v.remove(v.size()-1);
                }
                else
                {
                    last = q.peekFirst();
                    q.poll();
                }

                if(last/2 > 0)
                    q.add(last/2);

                ++count;
            }

            pw.println(last);
        }
        pw.flush();
        br.close();
        pw.close();

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
