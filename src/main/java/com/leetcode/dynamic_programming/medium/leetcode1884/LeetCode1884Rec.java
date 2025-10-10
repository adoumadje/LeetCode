package com.leetcode.dynamic_programming.medium.leetcode1884;

public class LeetCode1884Rec {
    Integer[][] mem;
    public int twoEggDrop(int n) {
        mem = new Integer[n+1][3];
        return dfs(n, 2);
    }

    private int dfs(int n, int e) {
        if(e == 1 || n <= 1) return n;
        if(mem[n][e] != null) return mem[n][e];
        mem[n][e] = n;
        for(int i = 1; i <= n; ++i) {
            mem[n][e] = Math.min(mem[n][e],
                    1 + Math.max(dfs(i-1, e-1), dfs(n-i, e)));
        }
        return mem[n][e];
    }
}
