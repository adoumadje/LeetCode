package com.leetcode.dynamic_programming.medium;

public class LeetCode3393 {
    int m, n, k;
    int[][] grid;
    long MOD = (long) 1e9 + 7;
    Long[][][] mem;

    public int countPathsWithXorValue(int[][] grid, int k) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.k = k;
        this.grid = grid;
        this.mem = new Long[m][n][17];
        return (int) dfs(0, 0, 0);
    }

    private long dfs(int xor, int r, int c) {
        if(r >= m || c >= n) return 0;
        int newXor = grid[r][c] ^ xor;
        if(r == m-1 && c == n-1)
            return newXor == k ? 1 : 0;
        if(mem[r][c][xor] != null) return mem[r][c][xor];
        long res = (dfs(newXor, r+1, c) % MOD + dfs(newXor, r, c+1) % MOD) % MOD;
        return mem[r][c][xor] = res;
    }
}
