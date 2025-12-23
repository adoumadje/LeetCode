package com.leetcode.dynamic_programming.medium;

public class LeetCode3196 {
    public long maximumTotalCost(int[] nums) {
        int n = nums.length;
        long[] dp = new long[n+1];
        dp[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; --i) {
            dp[i] = Math.max(nums[i] + dp[i+1], nums[i] - nums[i+1] + dp[i+2]);
        }
        return dp[0];
    }
}
