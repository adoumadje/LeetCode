package com.leetcode.dynamic_programming;

import java.util.Arrays;

public class LeetCode698 {
    Boolean[][] mem;
    int[] nums;
    int n, origTarget;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        n = nums.length;
        int sum = Arrays.stream(nums).reduce(0,Integer::sum);
        if(sum % k != 0) return false;
        this.nums = nums;
        mem = new Boolean[k+1][1 << n];
        this.origTarget = sum / k;
        return dfs(k, 0, origTarget);
    }

    private boolean dfs(int k, int mask, int target) {
        if(mask == (1 << n) - 1) {
            return k == 0;
        }
        if(mem[k][mask] != null) return mem[k][mask];
        boolean res = false;
        for(int i = 0; i < n; ++i) {
            if((mask & (1 << i)) == 0) {
                int newMask = mask | (1<<i);
                int diff = target - nums[i];
                if(diff > 0) {
                    res |= dfs(k, newMask, diff);
                } else if (diff == 0) {
                    res |= dfs(k-1, newMask, origTarget);
                }
            }
        }
        return mem[k][mask] = res;
    }
}
