package com.coding.codingninja.codechef.inputOutputHussainset;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class a1_hussainSet_COOK82C_usingFAstScannner2_MOSTOPTIMAL {
    public static void main (String[] args)	throws IOException{

        Reader sc = new Reader();
        OutputStream out = new BufferedOutputStream( System.out );

        int n = sc.nextInt();
        int m = sc.nextInt();

        long a[] = new long[n];

        for(int i = 0; i<n; i++) {
            a[i] = sc.nextLong();
        }
        Arrays.sort(a);

        int end_a = n-1, counter = 1;
        //Queue<Long> q = new LinkedList<>(n);
        //ArrayList<Long> q = new ArrayList<Long>(n);
        Queue<Long> q=new ArrayDeque<>();
        //StringBuilder sb = new StringBuilder(m);
        while(m-- > 0) {
            int query = sc.nextInt();
            long ans = 0;

            for( ; counter <= query; counter++) {
                if(end_a >= 0 && (q.isEmpty() || a[end_a] >= q.peek())) {
                    ans = a[end_a];
                    end_a--;
                }else {
                    ans = q.poll();
                }
                q.add(ans/2);
            }

            //sb.append(Long.toString(ans)+"\n");
            //System.out.println(ans);
            out.write((ans+"\n").getBytes());
        }
        out.flush();
        //System.out.println(sb);
}




    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
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
