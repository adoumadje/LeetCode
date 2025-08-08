package com.leetcode.dynamic_programming.medium;

public class LeetCode1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i <= m; ++i) dp[i][0] = i;
        for(int i = 1; i <= n; ++i) dp[0][i] = i;
        for(int i = 1; i <= m; ++i) {
            for(int j = 1; j <= n; ++j) {
                if(nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return ((m+n) - dp[m][n]) / 2;
    }
}
