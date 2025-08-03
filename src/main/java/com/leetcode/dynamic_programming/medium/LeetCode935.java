package com.leetcode.dynamic_programming.medium;

public class LeetCode935 {

    int[][] nexts = {{4,6}, {6,8}, {7,9}, {4,8}, {0,3,9}, {}, {0,1,7}, {2,6}, {1,3}, {2,4}};
                    /*  0     1      2      3      4      5      6      7       8      9   */
    Integer[][] mem;
    int MOD = (int) 1e9 + 7;
    public int knightDialer(int n) {
        int m = 10;
        mem = new Integer[m][n+1];
        long res = 0;
        for(int i = 0; i < m; ++i) {
            res += dfs(i, n) % MOD;
        }
        return (int) (res % MOD);
    }

    private int dfs(int i, int n) {
        if(n == 1) return 1;
        if(mem[i][n] != null) return mem[i][n];
        long res = 0;
        for(int next: nexts[i]) {
            res += dfs(next, n-1) % MOD;
        }
        return mem[i][n] = (int)(res % MOD);
    }
}
