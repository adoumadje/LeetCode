package com.leetcode.dynamic_programming.medium;

public class LeetCode3290 {
    int[] a, b;
    long INF = Long.MIN_VALUE + (long) (1e10);
    Long[][] mem;

    public long maxScore(int[] a, int[] b) {
        this.a = a;
        this.b = b;
        this.mem = new Long[a.length][b.length];
        return dfs(0, 0);
    }

    private long dfs(int i, int j) {
        if(i >= a.length)
            return 0;
        if(j >= b.length)
            return INF;
        if(mem[i][j] != null) return mem[i][j];
        long refuse = dfs(i, j+1);
        long accept = (long) a[i] * b[j] + dfs(i+1, j+1);
        return mem[i][j] = Math.max(accept, refuse);
    }
}
