package com.leetcode.dynamic_programming.medium.leetcode2750;

public class LeetCode2750Rec {
    int n;
    int[] nums;
    Long[] mem;
    long MOD = (long) (1e9+7);

    public int numberOfGoodSubarraySplits(int[] nums) {
        this.n = nums.length;
        this.mem = new Long[n];
        this.nums = nums;
        return (int) dfs(0);
    }

    private long dfs(int start) {
        if(start == n) return 1;
        if(mem[start] != null) return mem[start];
        long res = 0;
        int counter = 0;
        for(int i = start; i < n; ++i) {
            counter += nums[i];
            if(counter > 1) break;
            if(counter == 1)
                res = (res + dfs(i+1) % MOD) % MOD;
        }
        return mem[start] = res;
    }
}
