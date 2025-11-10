package com.leetcode.dynamic_programming.medium;

public class LeetCode2556 {
    int m, n;
    int[][] grid;

    public boolean isPossibleToCutPath(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        if(!dfs(0, 0)) return true;
        grid[0][0] = 1;
        return !dfs(0,0);
    }

    private boolean dfs(int r, int c) {
        if(r == m-1 && c == n-1) return true;
        if(r >= m || c >= n || grid[r][c] == 0) return false;
        grid[r][c] = 0;
        if(dfs(r+1, c)) return true;
        return dfs(r, c+1);
    }
}
