package com.leetcode.dynamic_programming;

public class LeetCode790 {
    Integer[][] mem;
    int MOD = (int)1e9 + 7;
    public int numTilings(int n) {
        mem = new Integer[n+1][n+1];
        return dfs(n, n);
    }

    private int dfs(int r1, int r2) {
        if(r1 == 0 && r2 == 0) return 1;
        if(r1 < 0 || r2 < 0) return 0;
        if(mem[r1][r2] != null) return mem[r1][r2];

        long res = 0;
        if(r1 == r2) {
            res += dfs(r1-2, r2-2);
            res += dfs(r1-1, r2-1);
            res += dfs(r1-1, r2-2);
            res += dfs(r1-2, r2-1);
        } else if (r1 > r2) {
            res += dfs(r1-2, r2);
            res += dfs(r1-2, r2-1);
        } else {
            res += dfs(r1, r2-2);
            res += dfs(r1-1, r2-2);
        }
        return mem[r1][r2] = (int) (res % MOD);
    }
}
