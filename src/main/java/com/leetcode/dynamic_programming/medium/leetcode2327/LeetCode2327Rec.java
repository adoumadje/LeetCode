package com.leetcode.dynamic_programming.medium.leetcode2327;

public class LeetCode2327Rec {
    int n, delay, forget;
    long MOD = (long) (1e9 +7);
    Long[] mem;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        this.n = n;
        this.delay = delay;
        this.forget = forget;
        this.mem = new Long[n+1];
        return (int) dfs(1);
    }

    private long dfs(int d) {
        if(d > n) return 0;
        if(mem[d] != null) return mem[d];
        long res = d+forget > n ? 1 : 0;
        for(int i = delay; i < forget; ++i) {
            res += dfs(d+i) % MOD;
            res %= MOD;
        }
        return mem[d] = res;
    }
}
