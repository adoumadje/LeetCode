package com.leetcode.dynamic_programming.medium;

import java.util.TreeSet;

public class LeetCode1981 {
    int m, n, target;
    TreeSet<Integer>[] mat;
    Integer[][] mem;

    public int minimizeTheDifference(int[][] mat, int target) {
        this.m = mat.length;
        this.n = mat[0].length;
        this.target = target;
        this.mat = new TreeSet[m];
        this.mem = new Integer[m][m * 70 + 1];
        for(int r = 0; r < m; ++r) {
            TreeSet<Integer> row = new TreeSet<>();
            for(int x: mat[r]) row.add(x);
            this.mat[r] = row;
        }
        return dfs(0, 0);
    }

    private int dfs(int row, int sum) {
        if(row == m) return Math.abs(sum - target);
        if(mem[row][sum] != null) return mem[row][sum];
        int res = Integer.MAX_VALUE ,next;
        for(int x: mat[row]) {
            res = Math.min(res, dfs(row + 1, sum + x));
            if(sum + x > target) break;
        }
        return mem[row][sum] = res;
    }
}
