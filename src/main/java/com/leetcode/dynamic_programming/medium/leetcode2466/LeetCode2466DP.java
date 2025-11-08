package com.leetcode.dynamic_programming.medium.leetcode2466;

public class LeetCode2466DP {
    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] dp = new long[high+1];
        long MOD = (long) (1e9+7);
        dp[0] = 1;
        long res = 0;
        for(int i = Math.min(zero, one); i <= high; ++i) {
            if(i-zero >= 0) dp[i] += dp[i-zero];
            if(i-one >= 0) dp[i] += dp[i-one];
            dp[i] %= MOD;
            if(i >= low) res = (res + dp[i]) % MOD;
        }
        return (int) res;
    }
}
