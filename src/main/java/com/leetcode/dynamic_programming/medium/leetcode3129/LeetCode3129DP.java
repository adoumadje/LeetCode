package com.leetcode.dynamic_programming.medium.leetcode3129;

public class LeetCode3129DP {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int MOD = (int) (1e9+7);
        int[][][] dp = new int[zero+1][one+1][2];
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;
        for(int z = 0; z <= zero; ++ z) {
            for(int o = 0; o <= one; ++o) {
                for(int l = 1; l <= limit; ++l) {
                    if(z-l >= 0) {
                        dp[z][o][1] = (dp[z][o][1] + dp[z-l][o][0]) % MOD;
                    }
                    if(o-l >= 0) {
                        dp[z][o][0] = (dp[z][o][0] + dp[z][o-l][1]) % MOD;
                    }
                }
            }
        }
        return (dp[zero][one][0] + dp[zero][one][1]) % MOD;
    }
}
