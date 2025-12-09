package com.leetcode.dynamic_programming.medium.leetcode2944;

public class LeetCode2944Rec {
    int n;
    Integer[][] mem;
    int[] prices;

    public int minimumCoins(int[] prices) {
        this.n = prices.length;
        this.mem = new Integer[n][2];
        this.prices = prices;
        return dfs(0, 0);
    }

    private int dfs(int i, int free) {
        if(i >= n) return 0;
        if(mem[i][free] != null) return mem[i][free];
        int res = 0;
        if(free == 0) {
            res = prices[i] + dfs(i+1, 1);
        } else {
            res = Math.min(prices[i] + dfs(i+1, 1), dfs(i+1, 0));
        }
        return mem[i][free] = res;
    }
}
