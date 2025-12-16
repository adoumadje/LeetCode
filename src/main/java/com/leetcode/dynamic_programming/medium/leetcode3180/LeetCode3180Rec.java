package com.leetcode.dynamic_programming.medium.leetcode3180;

public class LeetCode3180Rec {
    Integer[] mem = new Integer[2 * 2000];
    int[] nums;

    public int maxTotalReward(int[] rewardValues) {
        this.nums = rewardValues;
        return dfs(0);
    }

    private int dfs(int cap) {
        if (mem[cap] != null) return mem[cap];
        int res = 0;
        for (int x : nums) {
            if (x > cap)
                res = Math.max(res, x + dfs(cap + x));
        }
        return mem[cap] = res;
    }
}
