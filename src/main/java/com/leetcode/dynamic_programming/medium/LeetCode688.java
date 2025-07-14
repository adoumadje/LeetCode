package com.leetcode.dynamic_programming.medium;

public class LeetCode688 {
    int[][] deriv = new int[][]{{2, 1},{2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};
    Double[][][] mem;

    public double knightProbability(int n, int k, int row, int column) {
        mem = new Double[k+1][n][n];
        return dfs(n, k, row, column);
    }

    private double dfs(int n, int k, int r, int c) {
        if(r < 0 || r >= n || c < 0 || c >= n) return 0.0;
        if(k == 0) return 1.0;
        if (mem[k][r][c] != null) return mem[k][r][c];
        double res = 0.0;
        for(int[] dx: deriv) {
            res += dfs(n, k-1, r + dx[0], c + dx[1]);
        }
        return mem[k][r][c] = res / 8;
    }
}
