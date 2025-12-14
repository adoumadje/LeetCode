package com.leetcode.dynamic_programming.medium.leetcode3129;

public class LeetCode3129Rec {
    Long[][][] mem;
    int limit;
    long MOD = (long) (1e9+7);

    public int numberOfStableArrays(int zero, int one, int limit) {
        this.limit = limit;
        this.mem = new Long[zero+1][one+1][2];
        long res = (dfs(zero, one, 0) + dfs(zero, one,  1)) % MOD;
        return (int) res;
    }

    private long dfs(int zero,int one, int last) {
        if(zero == 0 && one == 0) return 1;
        if(mem[zero][one][last] != null) return mem[zero][one][last];
        long res = 0;
        for(int k = 1; k <= limit; ++k) {
            if(last == 0) {
                if(one-k >= 0) {
                    res = (res + dfs(zero, one-k, 1)) % MOD;
                }
            } else {
                if(zero-k >= 0) {
                    res = (res + dfs(zero-k, one, 0)) % MOD;
                }
            }
        }
        return mem[zero][one][last] = res;
    }
}
