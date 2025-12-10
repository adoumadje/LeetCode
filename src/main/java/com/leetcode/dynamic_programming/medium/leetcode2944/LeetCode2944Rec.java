package com.leetcode.dynamic_programming.medium.leetcode2944;

public class LeetCode2944Rec {
    int n;
    int[] prices;
    Integer[][] mem;

    public int minimumCoins(int[] prices) {
        this.n = prices.length;
        this.mem = new Integer[n][n+1];
        this.prices = prices;
        return dfs(0, 0);
    }

    private int dfs(int i, int free) {
        if(i >= n) return 0;
        if(mem[i][free] != null) return mem[i][free];
        int res = prices[i] + dfs(i+1, i+1);
        if(free > 0) {
            res = Math.min(res, dfs(i+1, free-1));
        }
        return mem[i][free] = res;
    }
}
