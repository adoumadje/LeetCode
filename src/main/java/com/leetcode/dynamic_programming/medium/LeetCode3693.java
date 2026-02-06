package com.leetcode.dynamic_programming.medium;

public class LeetCode3693 {
    int N, INF = Integer.MAX_VALUE;
    int[] costs;
    Integer[] mem;

    public int climbStairs(int n, int[] costs) {
        this.N = n;
        this.costs = costs;
        this.mem = new Integer[n];
        return dfs(0);
    }

    private int dfs(int i) {
        if(i == N) return 0;
        if(mem[i] != null) return mem[i];
        int res = INF;
        if(i+1 <= N) {
            res = Math.min(res, costs[i] + 1 + Math.min(dfs(i+1), INF - costs[i] - 1));
        }
        if(i+2 <= N) {
            res = Math.min(res, costs[i+1] + 4 + Math.min(dfs(i+2), INF - costs[i+1] - 4));
        }
        if(i+3 <= N) {
            res = Math.min(res, costs[i+2] + 9 + Math.min(dfs(i+3), INF - costs[i+2] - 9));
        }
        return mem[i] = res;
    }
}
