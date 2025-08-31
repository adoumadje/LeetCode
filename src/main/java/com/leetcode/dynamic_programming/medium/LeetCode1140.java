package com.leetcode.dynamic_programming.medium;

public class LeetCode1140 {
    int[] piles;
    int n;
    Integer[][][] mem;
    public int stoneGameII(int[] piles) {
        n = piles.length;
        this.piles = piles;
        mem = new Integer[2][n][2*n];
        return dfs(true, 0, 1);
    }

    public int dfs(boolean alice, int start, int M) {
        if(start >= n) return 0;
        int p = alice ? 0 : 1;
        if(mem[p][start][M] != null) return mem[p][start][M];
        int res = alice ? 0 : Integer.MAX_VALUE;
        int sum = 0;
        for(int x = 1; x <= 2 * M && start + x -1 < n; ++x) {
            sum += piles[start+ x -1];
            if(alice) {
                res = Math.max(res, sum + dfs(false, start+ x, Math.max(M, x)));
            } else {
                res = Math.min(res, dfs(true, start + x, Math.max(M, x)));
            }
        }
        return mem[p][start][M] = res;
    }
}
