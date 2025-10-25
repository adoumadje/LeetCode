package com.leetcode.dynamic_programming.medium;

public class LeetCode2222 {
    public long numberOfWays(String s) {
        char[] sa = s.toCharArray();
        int n = sa.length;
        /**
         *  0: 0       3: 1
         *  1: 10      4: 01
         *  2: 010     5: 101
         */
        long[] dp = new long[6];
        for(int i = n-1; i >= 0; --i) {
            if(sa[i] == '0') {
                dp[0] = 1 + dp[0];
                dp[4] = dp[3] + dp[4];
                dp[2] = dp[1] + dp[2];
            } else {
                dp[3] = 1 + dp[3];
                dp[1] = dp[0] + dp[1];
                dp[5] = dp[4] + dp[5];
            }
        }
        return (dp[2] + dp[5]);
    }
}
