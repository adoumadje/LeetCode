package com.leetcode.dynamic_programming.medium.leetcode2770;

public class LeetCode2770DP {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = n-2; i >= 0; --i) {
            dp[i] = -1;
            for(int j = i+1; j < n; ++j) {
                if(nums[j] - nums[i] >= -target
                        && nums[j] - nums[i] <= target && dp[j] >= 0) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        return dp[0];
    }
}
