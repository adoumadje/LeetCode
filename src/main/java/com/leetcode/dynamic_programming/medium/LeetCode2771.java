package com.leetcode.dynamic_programming.medium;

public class LeetCode2771 {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] dp = new int[2][n];
        /**
         * 0: nums1
         * 1: nums2
         */
        dp[0][0] = 1;
        dp[1][0] = 1;
        int res = 1;
        for(int i = 1; i < n; ++i) {
            dp[0][i] = 1;
            if(nums1[i] >= nums1[i-1])
                dp[0][i] = Math.max(dp[0][i], 1 + dp[0][i-1]);
            if(nums1[i] >= nums2[i-1])
                dp[0][i] = Math.max(dp[0][i], 1 + dp[1][i-1]);
            res = Math.max(res, dp[0][i]);
            dp[1][i] = 1;
            if(nums2[i] >= nums1[i-1])
                dp[1][i] = Math.max(dp[1][i], 1 + dp[0][i-1]);
            if(nums2[i] >= nums2[i-1])
                dp[1][i] = Math.max(dp[1][i], 1 + dp[1][i-1]);
            res = Math.max(res, dp[1][i]);
        }
        return res;
    }
}
