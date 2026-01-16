package com.leetcode.dynamic_programming.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode3543 {
    Integer[][][] mem;
    Map<Integer, List<int[]>> adj = new HashMap<>();
    int INF = Integer.MIN_VALUE;

    public int maxWeight(int n, int[][] edges, int k, int t) {
        this.mem = new Integer[n][k+1][t+1];
        for(int[] edge: edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).add(new int[]{v, w});
        }
        int res = INF;
        for(int i = 0; i < n; ++i) {
            res = Math.max(res, dfs(i, k, t));
        }
        return res < 0 ? -1 : res;
    }

    private int dfs(int i, int k, int t) {
        if(k == 0) return 0;
        if(mem[i][k][t] != null) return mem[i][k][t];
        int res = INF;
        if(!adj.containsKey(i)) return res;
        for(int[] vw: adj.get(i)) {
            int v = vw[0], w = vw[1];
            if(w < t) {
                res = Math.max(res, w + dfs(v, k-1, t-w));
            }
        }
        return mem[i][k][t] = res;
    }
}
