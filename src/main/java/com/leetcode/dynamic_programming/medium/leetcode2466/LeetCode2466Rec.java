package com.leetcode.dynamic_programming.medium.leetcode2466;

public class LeetCode2466Rec {
    int zero, one;
    Long[] mem;
    long MOD = (long) (1e9+7);

    public int countGoodStrings(int low, int high, int zero, int one) {
        this.zero = zero;
        this.one = one;
        mem = new Long[high+1];
        long res = 0;
        for(int len = low; len <= high; ++len) {
            res = (res + dfs(len)) % MOD;
        }
        return (int) res;
    }

    private long dfs(int len) {
        if(len == 0) return 1;
        if(len < 0) return 0;
        if(mem[len] != null) return mem[len];
        long res = (dfs(len-zero) + dfs(len-one)) % MOD;
        return mem[len] = res;
    }
}
