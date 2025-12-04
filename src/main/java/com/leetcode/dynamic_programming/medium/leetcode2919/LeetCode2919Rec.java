package com.leetcode.dynamic_programming.medium.leetcode2919;

import java.util.Arrays;

public class LeetCode2919Rec {
    int n, k;
    int[] nums;
    Long[] mem;

    public long minIncrementOperations(int[] nums, int k) {
        this.n = nums.length;
        this.k = k;
        this.nums = nums;
        this.mem = new Long[n];
        return dfs(0);
    }

    private long dfs(int i) {
        if(i + 2 >= n) return 0;
        if(mem[i] != null) return mem[i];
        long first = Math.max(0, k - nums[i]) + dfs(i+1);
        long second = Math.max(0, k - nums[i+1]) + dfs(i+2);
        long third = Math.max(0, k-nums[i+2]) + dfs(i+3);
        return mem[i] = min(first, second, third);
    }

    private long min(long ...arr) {
        return Arrays.stream(arr).min().orElseThrow();
    }
}
