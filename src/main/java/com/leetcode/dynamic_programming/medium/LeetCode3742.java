package com.leetcode.dynamic_programming.medium;

public class LeetCode3742 {
    int m, n, INF = Integer.MIN_VALUE;
    int[][] grid;
    Integer[][][] mem;
    int[] cost = {0, 1, 1};

    public int maxPathScore(int[][] grid, int k) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        this.mem = new Integer[m][n][k+1];
        int res = dfs(0, 0, k);
        return res >= 0 ? res : -1;
    }

    private int dfs(int r, int c, int k) {
        if (r >= m || c >= n) return INF;
        if (r == m - 1 && c == n - 1) return grid[r][c];
        if(mem[r][c][k] != null) return mem[r][c][k];
        int res = INF;
        int curr = grid[r][c];
        int right = INF;
        if(c+1 < n && k >= cost[grid[r][c+1]]) {
            right = dfs(r, c+1, k-cost[grid[r][c+1]]);
        }
        if (right != INF) {
            res = Math.max(res, curr + right);
        }
        int down = INF;
        if(r+1 < m && k >= cost[grid[r+1][c]]) {
            down = dfs(r+1, c, k-cost[grid[r+1][c]]);
        }
        if (down != INF) {
            res = Math.max(res, curr + down);
        }
        return mem[r][c][k] = res;
    }
}
