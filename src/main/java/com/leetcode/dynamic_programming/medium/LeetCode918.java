package com.leetcode.dynamic_programming.medium;

public class LeetCode918 {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int currMax = 0, globalMax = nums[0];
        int currMin = 0, globalMin = nums[0];
        for(int num: nums) {
            currMax = Math.max(currMax + num, num);
            globalMax = Math.max(globalMax, currMax);
            currMin = Math.min(currMin + num, num);
            globalMin = Math.min(globalMin, currMin);
            total += num;
        }
        return globalMax < 0 ? globalMax
                : Math.max(globalMax, total - globalMin);
    }
}
