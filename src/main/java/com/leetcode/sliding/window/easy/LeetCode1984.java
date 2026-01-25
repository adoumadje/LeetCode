package com.leetcode.sliding.window.easy;

import java.util.Arrays;

public class LeetCode1984 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int best = Integer.MAX_VALUE;
        for(int right = 0; right < n; ++right) {
            if(right - left == k) left += 1;
            if(right-left+1 == k) {
                best = Math.min(best, nums[right] - nums[left]);
            }
        }
        return best;
    }
}
