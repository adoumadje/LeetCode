package com.leetcode.dynamic_programming.medium;

public class LeetCode2597 {
    int k, n;
    int[] nums;
    Integer[] mem;

    public int beautifulSubsets(int[] nums, int k) {
        this.n = nums.length;
        this.k = k;
        this.nums = nums;
        mem = new Integer[1<<n];
        return dfs(0, 0);
    }

    private int dfs(int mask, int i) {
        if(i >= n) return mask != 0 ? 1 : 0;
        if (mem[mask] != null) return mem[mask];
        int res = dfs(mask, i+1);
        if(!kdiff(mask, nums[i])) {
            int newMask = mask | (1<<i);
            res += dfs(newMask, i+1);
        }
        return mem[mask] = res;
    }

    private boolean kdiff(int mask, int num) {
        for (int i = 0; i < n; ++i) {
            if((mask & (1<<i)) != 0 && Math.abs(num - nums[i]) == k)
                return true;
        }
        return false;
    }
}
