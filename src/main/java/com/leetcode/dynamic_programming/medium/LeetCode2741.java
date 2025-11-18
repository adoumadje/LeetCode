package com.leetcode.dynamic_programming.medium;

public class LeetCode2741 {
    int n;
    int[] nums;
    long MOD = (long) (1e9+7);
    Long[][] mem;

    public int specialPerm(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        int j = 0;
        this.mem = new Long[1<<n][n];
        long total = 0;
        for(int i = 0; i < n; ++i) {
            total = (total + dfs(1<<i, i) % MOD) % MOD;
        }
        return (int) total;
    }

    private long dfs(int mask, int prev) {
        if(mask == (1<<n) - 1)
            return 1;
        if(mem[mask][prev] != null) return mem[mask][prev];
        long res = 0;
        for(int i = 0; i < n; ++i) {
            if((mask & (1<<i)) == 0 &&
                    (nums[prev] % nums[i] == 0 || nums[i] % nums[prev] == 0)) {
                int newMak = mask | (1<<i);
                res = (res + dfs(newMak, i) % MOD) % MOD;
            }
        }
        return mem[mask][prev] = res;
    }
}
