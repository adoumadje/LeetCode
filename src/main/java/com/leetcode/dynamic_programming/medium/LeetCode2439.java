package com.leetcode.dynamic_programming.medium;

public class LeetCode2439 {
    public int minimizeArrayValue(int[] nums) {
        int res = 0, n = nums.length;
        double sum = 0.0;
        for(int i = 0; i < n; ++i) {
            sum += nums[i];
            res = (int) Math.max(res, Math.ceil(sum/(i+1)));
        }
        return res;
    }
}
