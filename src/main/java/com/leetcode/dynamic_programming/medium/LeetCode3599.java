package com.leetcode.dynamic_programming.medium;

public class LeetCode3599 {
    int[] nums;
    int n, INF = Integer.MAX_VALUE;
    Integer[][] mem;

    public int minXor(int[] nums, int k) {
        this.nums = nums;
        this.n = nums.length;
        this.mem = new Integer[n][k+1];
        return dfs(0, k);
    }

    private int dfs(int index, int k) {
        if(index == n) {
            return k == 0 ? 0 : INF;
        }
        if(k == 0) return INF;
        if(mem[index][k] != null) return mem[index][k];
        int best = INF;
        int xor = 0;
        for(int i = index; i < n; ++i) {
            xor ^= nums[i];
            best = Math.min(best, Math.max(xor, dfs(i+1, k-1)));
        }
        return mem[index][k] = best;
    }
}
