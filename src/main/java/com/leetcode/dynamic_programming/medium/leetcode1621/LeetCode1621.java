package com.leetcode.dynamic_programming.medium.leetcode1621;

import java.util.Arrays;

public class LeetCode1621 {
    public int numberOfSets(int n, int k) {
        long[][] d = new long[k+1][n];
        long[][] D = new long[k+1][n];

        long MOD = (long) (1e9 + 7);

        Arrays.fill(D[0], 1);

        for(int nn = 1; nn < n; ++nn) {
            for(int kk = 1; kk <= k; ++kk) {
                d[kk][nn] = (D[kk-1][nn-1] + d[kk][nn-1]) % MOD;
                D[kk][nn] = (D[kk][nn-1] + d[kk][nn]) % MOD;
            }
        }

        return (int) (d[k][n-1] % MOD);
    }
}
