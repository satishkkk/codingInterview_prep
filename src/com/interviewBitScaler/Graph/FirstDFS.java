package com.interviewBitScaler.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstDFS {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 1, 2));
        int B = 1;
        int C = 2;
        solve(A, B, C);
    }


    static int maxn = 100009;
    static int[] vis = new int[maxn];
    static ArrayList<ArrayList<Integer>> adj;

    public static void graph() {
        adj = new ArrayList<ArrayList<Integer>>(maxn);
        for (int i = 0; i < maxn; i++) {
            vis[i] = 0;
            adj.add(new ArrayList<Integer>());
        }
    }

    public static int solve(ArrayList<Integer> A, final int B, final int C) {
        graph();
        int n = A.size();
        for (int i = 1; i < n; i++) {
            adj.get(A.get(i)).add(i + 1);
        }
        if (dfs(C, B))
            return 1;
        return 0;
    }

    public static boolean dfs(int s, int D) {
        if (s == D)
            return true;
        vis[s] = 1;
        int i, j, k = adj.get(s).size();
        for (i = 0; i < k; i++) {
            j = adj.get(s).get(i);
            if (vis[j] == 0 && dfs(j, D))
                return true;
        }
        return false;
    }

}
