package com.leetcode.dynamic_programming.medium;

public class LeetCode3573 {
    int n, INF = Integer.MIN_VALUE;
    int[] prices;
    Long[][][] mem;

    public long maximumProfit(int[] prices, int k) {
        this.n = prices.length;
        this.prices = prices;
        this.mem = new Long[3][n][k+1];
        return free(0, k);
    }

    private long free(int i, int k) {
        if(i >= n) return 0;
        if(mem[0][i][k] != null) return mem[0][i][k];
        long best = 0;
        // Not doing anything
        best = Math.max(best, free(i+1, k));
        if(k > 0) {
            // Initiate a Buy Operation
            best = Math.max(best, -prices[i] + canSell(i+1, k-1));
            // Initiate a Sell Operation
            best = Math.max(best, prices[i]  + canBuy(i+1, k-1));
        }
        return mem[0][i][k] = best;
    }

    private long canBuy(int i, int k) {
        if(i >= n) return INF;
        if(mem[1][i][k] != null) return mem[1][i][k];
        long best  = INF;
        best = Math.max(best, -prices[i] + free(i+1, k));
        best = Math.max(best, canBuy(i+1, k));
        return mem[1][i][k] = best;
    }

    private long canSell(int i, int k) {
        if(i >= n) return INF;
        if(mem[2][i][k] != null) return mem[2][i][k];
        long best = INF;
        best = Math.max(best, prices[i] + free(i+1, k));
        best = Math.max(best, canSell(i+1, k));
        return mem[2][i][k] = best;
    }
}
