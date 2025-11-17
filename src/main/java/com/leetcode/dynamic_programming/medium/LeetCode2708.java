package com.leetcode.dynamic_programming.medium;

import java.util.Arrays;

public class LeetCode2708 {
    public long maxStrength(int[] nums) {
        long prevMax = nums[0], prevMin = nums[0];
        for(int i = 1; i < nums.length; ++i) {
            long currMax = max(prevMax, prevMax * nums[i], prevMin * nums[i], nums[i]);
            long currMin = min(prevMin, prevMax * nums[i], prevMin * nums[i], nums[i]);
            prevMax = currMax;
            prevMin = currMin;
        }
        return prevMax;
    }

    private long max(long ...arr) {
        return Arrays.stream(arr).max().orElseThrow();
    }

    private long min(long ...arr) {
        return Arrays.stream(arr).min().orElseThrow();
    }
}
