package com.leetcode.dynamic_programming.medium;

public class LeetCode1277 {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int total = 0;
        for(int r = m-1; r >= 0; --r) {
            for(int c = n-1; c >= 0; --c) {
                if(matrix[r][c] == 1 && r < m-1 && c < n-1) {
                    matrix[r][c] = 1 + Math.min(matrix[r+1][c+1],
                            Math.min(matrix[r+1][c], matrix[r][c+1]));
                }
                total += matrix[r][c];
            }
        }
        return total;
    }
}
