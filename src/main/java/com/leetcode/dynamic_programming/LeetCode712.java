package com.leetcode.dynamic_programming;

public class LeetCode712 {
    public int minimumDeleteSum(String s1, String s2) {
        char[] sa1 = s1.toCharArray();
        char[] sa2 = s2.toCharArray();
        int m = sa1.length;
        int n = sa2.length;
        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= n; ++i) {
            dp[0][i] = sa2[i-1] + dp[0][i-1];
        }

        for(int i = 1; i <= m; ++i) {
            dp[i][0] = sa1[i-1] + dp[i-1][0];
        }

        for(int i = 1; i <= m; ++i) {
            for(int j = 1; j <= n; ++j) {
                if(sa1[i-1] == sa2[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(sa1[i-1] + dp[i-1][j],
                            sa2[j-1] + dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
}
