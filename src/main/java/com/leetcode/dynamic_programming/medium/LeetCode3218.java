package com.leetcode.dynamic_programming.medium;

public class LeetCode3218 {
    int[] horizontal, vertical;
    Integer[][][][] mem;

    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        this.horizontal = horizontalCut;
        this.vertical = verticalCut;
        this.mem = new Integer[m][m+1][n][n+1];
        return dfs(0, m, 0, n);
    }

    private int dfs(int ri, int rf, int ci, int cf) {
        if(rf-ri == 1 && cf-ci == 1) return 0;
        if(mem[ri][rf][ci][cf] != null) return mem[ri][rf][ci][cf];
        int res = Integer.MAX_VALUE;
        for(int i = ri + 1; i < rf; ++i) {
            res = Math.min(res, horizontal[i-1] + dfs(ri, i, ci, cf) + dfs(i, rf, ci, cf));
        }
        for(int j = ci+1; j < cf; ++j) {
            res = Math.min(res, vertical[j-1] + dfs(ri, rf, ci, j) + dfs(ri, rf, j, cf));
        }
        return mem[ri][rf][ci][cf] = res;
    }
}
