package com.leetcode.dynamic_programming.medium;

public class LeetCode3192 {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ops, ones, zeros;
        ops = ones = zeros = 0;
        for(int i = n-1; i >= 0; --i) {
            if(nums[i] == 1) {
                ones += 1;
            } else {
                zeros += 1;
                if(i == 0 || nums[i] != nums[i-1]) {
                    ops += ones > 0 ? 2 : 1;
                    ones += zeros;
                    zeros = 0;
                }
            }
        }
        return ops;
    }
}
