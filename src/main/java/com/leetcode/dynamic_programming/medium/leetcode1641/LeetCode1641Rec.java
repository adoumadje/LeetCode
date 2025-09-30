package com.leetcode.dynamic_programming.medium.leetcode1641;

public class LeetCode1641Rec {
    int N;
    int W = 5;
    Integer[][] mem;
    public int countVowelStrings(int n) {
        this.N = n;
        mem = new Integer[W][n+1];
        return dfs(0, n);
    }

    private int dfs(int pos, int n) {
        if(n == 1) {
            return W-pos;
        }
        if(mem[pos][n] != null) return mem[pos][n];
        int res = 0;
        for(int i = pos; i < W; ++i) {
            res += dfs(i, n-1);
        }
        return mem[pos][n] = res;
    }
}
