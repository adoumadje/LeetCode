package com.leetcode.dynamic_programming.medium;

public class LeetCode3665 {
    int[][] grid;
    long MOD = (long) 1e9 + 7;
    int m, n;
    Long[][][] mem;

    public int uniquePaths(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.mem = new Long[m][n][3];
        return Math.toIntExact(dfs(0, 0, 2));
    }

    /**
     *
     * @param i
     * @param j
     * @param direction (0: right, 1: down)
     * @return
     */
    private long dfs(int i, int j, int direction) {
        if(i >= m || j >= n) return 0;
        if(i == m-1 && j == n-1) return 1;
        if(mem[i][j][direction] != null) return mem[i][j][direction];
        long res = 0;
        if(grid[i][j] == 0) {
            res = (dfs(i+1, j, 1) % MOD + dfs(i, j+1, 0) % MOD) % MOD;
        } else {
            res = direction == 0 ? dfs(i+1, j, 1) % MOD
                : dfs(i, j+1, 0) % MOD;
        }
        return mem[i][j][direction] = res;
    }
}
