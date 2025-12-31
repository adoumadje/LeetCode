package com.leetcode.dynamic_programming.medium;

import java.util.List;

public class LeetCode3376 {
    int ALL, N, K, INF = Integer.MAX_VALUE;
    Integer[][] mem;
    List<Integer> strength;

    public int findMinimumTime(List<Integer> strength, int k) {
        this.N = strength.size();
        this.ALL = (1<<N) - 1;
        this.K = k;
        this.mem = new Integer[1<<N][N*k+2];
        this.strength = strength;
        return dfs(0, 1);
    }

    private int dfs(int mask, int x) {
        if(mask == ALL) return 0;
        if(mem[mask][x] != null) return mem[mask][x];
        int res = INF;
        for(int i = 0; i < N; ++i) {
            if((mask & (1<<i)) == 0) {
                int newMak = mask | (1<<i);
                int cost = (strength.get(i) + x - 1) / x;
                res = Math.min(res, cost + dfs(newMak, x+K));
            }
        }
        return mem[mask][x] = res;
    }
}
