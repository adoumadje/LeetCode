package com.leetcode.dynamic_programming.medium;

public class LeetCode2684 {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] prev = new int[m];
        int res = 0;
        for(int c = n-2; c >= 0; --c) {
            int[] curr = new int[m];
            for(int r = 0; r < m; ++r) {
                if(r-1 >= 0 && grid[r-1][c+1] > grid[r][c])
                    curr[r] = Math.max(curr[r], 1 + prev[r-1]);
                if(grid[r][c+1] > grid[r][c])
                    curr[r] = Math.max(curr[r], 1 + prev[r]);
                if(r+1 < m && grid[r+1][c+1] > grid[r][c])
                    curr[r] = Math.max(curr[r], 1 + prev[r+1]);
                if(c == 0)
                    res = Math.max(res, curr[r]);
            }
            prev = curr;
        }
        return res;
    }
}
