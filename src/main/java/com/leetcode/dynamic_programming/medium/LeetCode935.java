package com.leetcode.dynamic_programming.medium;

public class LeetCode935 {
    Integer[][][] mem;
    int MOD = (int) 1e9 + 7;
    int row, col;
    int[][] derivs = new int[][] {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
    };

    public int knightDialer(int n) {
        row = 4;
        col = 3;
        mem = new Integer[row][col][n+1];

        long res = 0;
        for(int r = 0; r < row; ++r) {
            for(int c = 0; c < col; ++c) {
                res += dfs(r, c, n) % MOD;
            }
        }

        return (int) (res % MOD);
    }

    private int dfs(int r, int c, int n) {
        if(r < 0 || r >= row || c < 0 || c >= col || (r == 3 && c != 1)) {
            return 0;
        }
        if(n == 1) return 1;
        if(mem[r][c][n] != null) return mem[r][c][n];
        long res = 0;
        for(int[] d: derivs) {
            res += dfs(r + d[0], c + d[1], n-1) % MOD;
        }
        return mem[r][c][n] = (int) (res % MOD);
    }
}
