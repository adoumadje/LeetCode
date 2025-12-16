package com.leetcode.dynamic_programming.medium.leetcode3176;

public class LeetCode3176Rec {
    int n;
    Integer[][] mem;
    int[] nums;

    public int maximumLength(int[] nums, int k) {
        this.n = nums.length;
        this.mem = new Integer[n][k+1];
        this.nums = nums;
        int res = 0;
        for(int i = 0; i < n; ++i) {
            res = Math.max(res, 1 + dfs(i, k));
        }
        return res;
    }

    private int dfs(int pi, int k) {
        if(pi >= n) return 0;
        if(mem[pi][k] != null) return mem[pi][k];
        int res = 0;
        for(int i = pi+1; i < n; ++i) {
            if(nums[i] == nums[pi]) {
                res = Math.max(res, 1 + dfs(i, k));
            } else if (k > 0) {
                res = Math.max(res, 1 + dfs(i, k-1));
            }
        }
        return mem[pi][k] = res;
    }
}
