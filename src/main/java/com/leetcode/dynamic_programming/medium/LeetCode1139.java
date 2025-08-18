package com.leetcode.dynamic_programming.medium;

public class LeetCode1139 {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] above = new int[m][n];
        int[][] below = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];

        for(int c = 0; c <  n; ++c) {
            above[0][c] = grid[0][c];
            for(int r = 1; r < m; ++r) {
                if(grid[r][c] != 0) {
                    above[r][c] = above[r-1][c] + 1;
                }
            }
        }

        for(int c = 0; c <  n; ++c) {
            below[m-1][c] = grid[m-1][c];
            for(int r = m-2; r >= 0; --r) {
                if(grid[r][c] != 0) {
                    below[r][c] = below[r+1][c] + 1;
                }
            }
        }

        for(int r = 0; r < m; ++r) {
            left[r][0] = grid[r][0];
            for(int c = 1; c < n; ++c) {
                if(grid[r][c] != 0) {
                    left[r][c] = left[r][c-1] + 1;
                }
            }
        }

        for(int r = 0; r < m; ++r) {
            right[r][n-1] = grid[r][n-1];
            for(int c = n-2; c >= 0; --c) {
                if(grid[r][c] != 0) {
                    right[r][c] = right[r][c+1] + 1;
                }
            }
        }

        int res = 0;

        for(int r = 0; r < m; ++r) {
            for(int c = 0; c < n; ++c) {
                for(int i = 0; i < Math.min(right[r][c], below[r][c]); ++i) {
                    if(above[r+i][c+i] >= i+1 && left[r+i][c+i] >= i+1) {
                        res = Math.max(res, (int)Math.pow(i+1, 2));
                    }
                }
            }
        }

        return res;
    }
}
