package com.leetcode.dynamic_programming;

import java.util.Arrays;

public class LeetCode650 {
    boolean[] prime;

    public int minSteps(int n) {
        this.prime = getPrimes(n);
        int[] dp = new int[n+1];
        for(int i = 2; i <= n; ++i) {
            for(int j = 2; j <= i; ++j) {
                if(prime[j] && i % j == 0) {
                    dp[i] = j + dp[i/j];
                }
            }
        }
        return dp[n];
    }

    private boolean[] getPrimes(int n) {
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        primes[0] = false;
        for(int i = 2; i <= n; ++i) {
            if(!primes[i]) continue;
            for(int j = i*2; j <= n; j += i) {
                primes[j] = false;
            }
        }
        return primes;
    }
}
