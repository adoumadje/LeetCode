package com.leetcode.dynamic_programming.medium;

public class LeetCode2673 {
    int n, total = 0;
    int[] cost;

    public int minIncrements(int n, int[] cost) {
        this.n = n;
        this.cost = cost;
        dfs(1);
        return total;
    }

    private int dfs(int i) {
        if(i > n) return 0;
        int left = dfs(i*2);
        int right = dfs(i*2+1);
        total += Math.abs(left - right);
        return Math.max(left, right) + cost[i-1];
    }
}
