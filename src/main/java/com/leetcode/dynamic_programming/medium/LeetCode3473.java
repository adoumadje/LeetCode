package com.leetcode.dynamic_programming.medium;

public class LeetCode3473 {
    int INF = Integer.MIN_VALUE + (int)2e7;
    int n, M;
    int[] nums;
    Integer[][][] mem;

    public int maxSum(int[] nums, int k, int m) {
        this.n = nums.length;
        this.M = m;
        this.nums = nums;
        this.mem = new Integer[3][n][k+1];
        return dfs(0, 0, k);
    }

    private int dfs(int i, int len, int k) {
        if(i >= n) return k == 0 ? 0 : INF;
        if(k == 0) return 0;
        int m = 0;
        if(len > 0)
            m = len + 1 < M ? 1 : 2;
        if(mem[m][i][k] != null) return mem[m][i][k];
        int skip = Integer.MIN_VALUE;
        if(len == 0)
            skip = dfs(i+1, 0, k);
        int addContinue = nums[i] + dfs(i+1, len+1, k);
        int addStop = Integer.MIN_VALUE;
        if(len + 1 >= M) {
            addStop = nums[i] + dfs(i+1, 0, k-1);
        }
        return mem[m][i][k] = Math.max(skip, Math.max(addContinue, addStop));
    }
}
