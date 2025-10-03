package com.leetcode.dynamic_programming.medium;

public class LeetCode1653 {
    public int minimumDeletions(String s) {
        char[] sa = s.toCharArray();
        int n = sa.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int lis = 1;
        for(int i = 1; i < n; ++i) {
            dp[i] = 1;
            for(int j = i-1; j >= 0; --j) {
                if(sa[j] <= sa[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            lis = Math.max(lis, dp[i]);
        }
        return n-lis;
    }
}
