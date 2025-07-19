package com.leetcode.dynamic_programming.medium;

import java.util.Arrays;

public class LeetCode837 {
    public double new21Game(int n, int k, int maxPts) {
        if(k == 0) return 1.0;
        if(n >= k-1 + maxPts) return 1.0;
        int maxScore = k-1 + maxPts;
        double[] dp = new double[n+1];
        double probability = 0.0;
        double win = 1.0;
        dp[0] = 1.0;
        for(int i = 1; i <= n; ++i) {
            dp[i] = win * 1.0 / maxPts;
            if(i < k) {
                win += dp[i];
            } else {
                probability += dp[i];
            }
            if(i >= maxPts) {
                win -= dp[i-maxPts];
            }
        }
        return probability;
    }
}
