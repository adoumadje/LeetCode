package com.leetcode.dynamic_programming.medium;

public class LeetCode2930 {
    long MOD = (long) (1e9+7);

    public int stringCount(int n) {
        if(n < 4) return 0;

        long total = power(26, n);

        long l0 = power(25, n);
        long e0 = power(25, n);
        long e1 = n * power(25, n-1) % MOD;
        long e_2 = (e0 + e1) % MOD;
        long t0 = power(25, n);

        long l0_n_e0 = power(24, n);
        long l0_n_e1 = n * power(24, n-1) % MOD;
        long l0_n_e_2 = (l0_n_e0 + l0_n_e1) % MOD;

        long l0_n_t0 = power(24, n);

        long e0_n_t0 = power(24, n);
        long e1_n_t0 = n * power(24, n-1);
        long e_2_n_t0 = (e0_n_t0 + e1_n_t0) % MOD;

        long l0_n_e0_n_t0 = power(23, n);
        long l0_n_e1_n_t0 = n * power(23, n-1);
        long l0_n_e_2_n_t0 = (l0_n_e0_n_t0 + l0_n_e1_n_t0) % MOD;

        long unwanted = (l0 + e_2 + t0 - l0_n_e_2 - l0_n_t0 - e_2_n_t0 + l0_n_e_2_n_t0) % MOD;

        System.out.println("total = " + total);
        System.out.println("unwanted = " + unwanted);

        long res = (total - unwanted + MOD) % MOD;
        return (int) res;
    }

    private long power(long a, int b) {
        long r = 1;
        while(b > 0) {
            if((b&1) != 0) r = (r * a) % MOD;
            a = (a * a) % MOD;
            b = b >> 1;
        }
        return r;
    }
}
