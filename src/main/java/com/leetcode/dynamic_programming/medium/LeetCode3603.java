package com.leetcode.dynamic_programming.medium;

public class LeetCode3603 {
    int[][] wait;
    int M, N;
    long INF = Long.MAX_VALUE;
    Long[][] mem;

    public long minCost(int m, int n, int[][] waitCost) {
        waitCost[0][0] = 0;
        this.wait = waitCost;
        this.M = m;
        this.N = n;
        this.mem = new Long[M][N];
        return dfs(0, 0);
    }

    private long dfs(int i, int j) {
        if(i >= M || j >= N) return INF;
        if(i == M-1 && j == N-1) return M*N;
        if(mem[i][j] != null) return mem[i][j];
        long right = dfs(i, j+1);
        long down = dfs(i+1, j);
        long best = Math.min(right, down);
        if(best == INF) return mem[i][j] = best;
        return mem[i][j] = (long) (i + 1) * (j+1) + wait[i][j] + best;
    }
}
