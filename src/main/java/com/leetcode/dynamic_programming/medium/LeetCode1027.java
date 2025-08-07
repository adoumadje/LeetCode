package com.leetcode.dynamic_programming.medium;

public class LeetCode1027 {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int x: nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        int universe = max - min;
        int[][] dp = new int[n][2 * universe + 1];
        int res = 0;
        for(int i = 1; i < n; ++i) {
            for(int j = i-1; j >= 0; --j) {
                int d = nums[i] - nums[j] + universe;
                dp[i][d] = Math.max(dp[i][d], dp[j][d] + 1);
                res = Math.max(res, dp[i][d] + 1);
            }
        }
        return res;
    }
}
