package com.leetcode.daily.Y2025.july;

import java.util.Arrays;

public class LeetCode3487 {
    public int maxSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = nums[n-1];
        for(int i = n-2; i >= 0; --i) {
            if(nums[i] > 0 && nums[i] != nums[i+1]) {
                sum += nums[i];
            }
        }
        return sum;
    }
}
