package com.leetcode.dynamic_programming.medium.leetcode2400;

public class LeetCode2400Rec {
    int start, end;
    long MOD = (long) (1e9+7);
    Long[][] mem;
    public int numberOfWays(int startPos, int endPos, int k) {
        this.start = startPos + k;
        this.end = endPos + k;
        mem = new Long[end+k+1][k+1];
        int res = (int) (dfs(end, k) % MOD);
        return res;
    }

    private long dfs(int i, int k) {
        if(k == 0)
            return i == start ? 1 : 0;
        if(mem[i][k] != null) return mem[i][k];
        long res = (dfs(i-1, k-1)  + dfs(i+1, k-1)) % MOD;
        return mem[i][k] = res;
    }
}
