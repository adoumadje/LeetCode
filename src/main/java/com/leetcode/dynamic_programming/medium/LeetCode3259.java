package com.leetcode.dynamic_programming.medium;

public class LeetCode3259 {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        /**
         * 0: A
         * 1: B
         */
        long[][] dp = new long[2][n+2];
        for(int i = n-1; i >= 0; --i) {
            dp[0][i] = energyDrinkA[i] + Math.max(dp[0][i+1], dp[1][i+2]);
            dp[1][i] = energyDrinkB[i] + Math.max(dp[1][i+1], dp[0][i+2]);
        }
        return Math.max(dp[0][0], dp[1][0]);
    }
}
