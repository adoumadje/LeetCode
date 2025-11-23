package com.leetcode.dynamic_programming.medium.leetcode2786;

public class LeetCode2786Rec {
    int x, n;
    int[] nums;
    Long[][] mem;

    public long maxScore(int[] nums, int x) {
        this.x = x;
        this.n = nums.length;
        this.nums = nums;
        this.mem = new Long[2][n];
        return nums[0] + dfs(nums[0]%2, 1);
    }

    private long dfs(int prev, int i) {
        if(i == n) return 0;
        if(mem[prev][i] != null) return mem[prev][i];
        int parity = nums[i] % 2;
        int fine = parity == prev ? 0 : -x;
        return mem[prev][i] = Math.max(nums[i] + fine + dfs(parity, i+1),
                dfs(prev, i+1));
    }
}
