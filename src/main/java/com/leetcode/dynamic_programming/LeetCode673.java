package com.leetcode.dynamic_programming;

public class LeetCode673 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        int[] count = new int[n];
        int len = 0;

        for(int i = 0; i < n; ++i) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for(int j = i-1; j >= 0; --j) {
                if(nums[j] < nums[i]) {
                    int l = 1 + dp[j][0];
                    int ct = dp[j][1];
                    if(l > dp[i][0]) {
                        dp[i][0] = l;
                        dp[i][1] = ct;
                    } else if (l == dp[i][0]) {
                        dp[i][1] += ct;
                    }
                }
            }
            count[dp[i][0]] += dp[i][1];
            len = Math.max(len, dp[i][0]);
        }

        return count[len];
    }
}
