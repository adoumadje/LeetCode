package com.leetcode.dynamic_programming.medium;

public class LeetCode3469 {
    int[] nums;
    int n;
    Integer[][] mem;

    public int minCost(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.mem = new Integer[n][n];
        return dfs(1, 0);
    }

    private int dfs(int i, int p) {
        if(i >= n) return nums[p];
        if(i+1 >= n) return Math.max(nums[i], nums[p]);
        if(mem[i][p] != null) return mem[i][p];
        /**
         *  p: a, i: b, i+1: c
         */
        int ab = Math.max(nums[p], nums[i]) + dfs(i+2, i+1);
        int ac = Math.max(nums[p], nums[i+1]) + dfs(i+2, i);
        int bc = Math.max(nums[i], nums[i+1]) + dfs(i+2, p);
        return mem[i][p] = Math.min(bc, Math.min(ab, ac));
    }
}
