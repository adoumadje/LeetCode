package com.leetcode.dynamic_programming.medium;

public class LeetCode1039 {
    Integer[][] mem;
    int[] values;

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        this.values = values;
        mem = new Integer[n][n];
        return dfs(0, n-1);
    }

    public int dfs(int i, int j) {
        if(j-i < 2) return 0;
        if(j-i == 2) return values[i] * values[i+1] * values[j];
        if(mem[i][j] != null) return mem[i][j];
        int res = Integer.MAX_VALUE;
        for(int k = i+1; k < j; ++k) {
            res = Math.min(res, values[i] * values[k] * values[j] + dfs(i, k) + dfs(k, j));
        }
        return mem[i][j] = res;
    }
}
