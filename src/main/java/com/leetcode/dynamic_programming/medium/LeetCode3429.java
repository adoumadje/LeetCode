package com.leetcode.dynamic_programming.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode3429 {
    int n;
    long INF = Long.MAX_VALUE;
    List<int[]> combination = new ArrayList<>();
    Long[][][] mem;
    int[][] cost;

    public long minCost(int n, int[][] cost) {
        this.n = n;
        this.cost = cost;
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                if(i != j)
                    combination.add(new int[]{i, j});
            }
        }
        this.mem = new Long[n][4][4];
        return dfs(0, 3, 3);
    }

    private long dfs(int i, int fl, int fr) {
        if(2*i == n) return 0;
        if(mem[i][fl][fr] != null) return mem[i][fl][fr];
        long res = INF;
        for(int[] comb: combination) {
            int l = comb[0], r = comb[1];
            if(l != fl && r != fr) {
                res = Math.min(res, cost[i][l] + cost[n-1-i][r] + dfs(i+1, l, r));
            }
        }
        return mem[i][fl][fr] = res;
    }
}
