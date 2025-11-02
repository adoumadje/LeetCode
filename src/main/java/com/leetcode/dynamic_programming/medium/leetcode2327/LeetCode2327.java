package com.leetcode.dynamic_programming.medium.leetcode2327;

public class LeetCode2327DP {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long MOD = (long) (1e9 + 7);
        long counter = 0;
        long res = 1 + forget > n ? 1 : 0;
        long[] dp = new long[n+1];
        dp[1] = 1;
        for(int i = 2; i <= n; ++i) {
            if(i-delay > 0) counter += dp[i-delay];
            if(i-forget > 0) counter -= dp[i-forget];
            dp[i] = counter % MOD;
            if(i > n-forget) res = (res + dp[i] )% MOD;
        }
        return (int) res;
    }
}
