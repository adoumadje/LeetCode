package com.leetcode.dynamic_programming.medium;

import java.util.Arrays;

public class LeetCode2304 {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        int[] prev = new int[n], curr = new int[n];
        for(int i = 0; i < n; ++i) prev[i] = grid[0][i];
        for(int r = 1; r < m; ++r) {
            Arrays.fill(curr, Integer.MAX_VALUE);
            for(int c = 0; c < n; ++c) {
                for(int pc = 0; pc < n; ++pc) {
                    int prevCell = grid[r-1][pc];
                    int currCell = grid[r][c];
                    int pathCost = moveCost[prevCell][c];
                    curr[c] = Math.min(curr[c], prev[pc] + pathCost + currCell);
                }
            }
            prev = curr.clone();
        }
        return Arrays.stream(prev).min().orElseThrow();
    }
}
