package com.leetcode.sliding.window.medium;

public class LeetCode413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i+2 < n; ++i) {
            int j = i+2;
            for(;j < n; ++j) {
                if(nums[j] - nums[j-1] != nums[j-1] - nums[j-2])
                    break;
            }
            count += j-i-2;
        }
        return count;
    }
}
