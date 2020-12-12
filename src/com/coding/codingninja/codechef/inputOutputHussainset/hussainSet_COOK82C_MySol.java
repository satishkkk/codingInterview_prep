package com.coding.codingninja.codechef.inputOutputHussainset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class hussainSet_COOK82C_MySol {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0, q = 0;
        String str;

        str = br.readLine();

        StringTokenizer tokenizer;
        tokenizer = new StringTokenizer(str, " ");
        while (tokenizer.hasMoreTokens()) {
            n = Integer.parseInt(tokenizer.nextToken());
            q = Integer.parseInt(tokenizer.nextToken());
        }

        str = br.readLine();
        tokenizer = new StringTokenizer(str, " ");
        long arr[] = new long[n];
        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            arr[i++] = Long.parseLong(tokenizer.nextToken());
        }

        Arrays.sort(arr);

        Queue<Long> queue = new ArrayDeque<>();

        int count_m = 0;
        int end_p = n - 1;

        while (q-- > 0) {
            int curr_m = Integer.parseInt(br.readLine());
            long ans = 0;
            for (; count_m < curr_m; count_m++) {
                if (end_p >= 0 && (queue.isEmpty() || arr[end_p] >= queue.element())) {
                    ans = arr[end_p];
                    end_p--;
                } else {
                    ans = queue.element();
                    queue.remove();
                }
                queue.add(ans / 2);
            }
            System.out.println(ans);
        }

    }
}
