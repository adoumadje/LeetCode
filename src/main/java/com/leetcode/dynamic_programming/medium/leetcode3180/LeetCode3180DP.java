package com.leetcode.dynamic_programming.medium.leetcode3180;

public class LeetCode3180DP {
    public int maxTotalReward(int[] rewardValues) {
        int MAX = 2000;
        int[] dp = new int[2*MAX];
        for(int cap = MAX-1; cap >= 0; --cap) {
            for(int x: rewardValues) {
                if(x > cap) {
                    dp[cap] = Math.max(dp[cap], x + dp[cap+x]);
                }
            }
        }
        return dp[0];
    }
}
