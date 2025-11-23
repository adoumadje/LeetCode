package com.leetcode.dynamic_programming.medium.leetcode2787;

import java.util.ArrayList;
import java.util.List;

public class LeetCode2787DP {
    public int numberOfWays(int n, int x) {
        List<Integer> powers = generatePowers(n, x);
        long MOD = (long) (1e9+7);
        long[] dp = new long[n+1];
        dp[0] = 1;
        for(int p: powers) {
            for(int nn = n; nn >= p; --nn) {
                dp[nn] = (dp[nn] + dp[nn-p] % MOD) % MOD;
            }
        }
        return (int) dp[n];
    }

    private List<Integer> generatePowers(int n, int x) {
        List<Integer> list = new ArrayList<>();
        int a = 1, p;
        while ((p = power(a++, x)) <= n) {
            list.add(p);
        }
        return list;
    }

    private int power(int a, int x) {
        int p = 1;
        while(x > 0) {
            if((x&1) != 0) p *= a;
            a *= a;
            x = x >> 1;
        }
        return p;
    }
}
