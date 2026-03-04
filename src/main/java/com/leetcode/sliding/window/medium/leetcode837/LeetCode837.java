package com.leetcode.sliding.window.medium.leetcode837;

public class LeetCode837 {
    public double new21Game(int n, int k, int maxPts) {
        int maxScore = k-1+maxPts;
        if(maxScore <= n) return 1.0;
        double[] dp = new double[n+1];
        double total = 0.0;
        int r = n;
        for(int i = n; i >= 0; --i) {
            if(i >= k) {
                dp[i] = 1.0;
            } else {
                dp[i] = total / maxPts;
            }
            total += dp[i];
            if(r-i+1 > maxPts) {
                total -= dp[r--];
            }
        }
        return dp[0];
    }
}
