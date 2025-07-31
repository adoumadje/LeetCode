package com.leetcode.dynamic_programming.medium;

public class LeetCode931 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        for(int r = n-1; r >= 0; --r) {
            for(int c = 0; c < n; ++c) {
                if(r < n-1) {
                    int down = matrix[r+1][c];
                    int left = c == 0 ? Integer.MAX_VALUE : matrix[r+1][c-1];
                    int right = c == n-1 ? Integer.MAX_VALUE : matrix[r+1][c+1];
                    matrix[r][c] +=  Math.min(down, Math.min(left, right));
                }
                if(r == 0) {
                    res = Math.min(res, matrix[r][c]);
                }
            }
        }
        return res;
    }
}
