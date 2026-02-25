package com.leetcode.sliding.window.medium;

public class LeetCode713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int product = 1, count = 0;
        int l = 0;
        for(int r = 0; r < n; ++r) {
            product *= nums[r];
            while (l <= r && product >= k) {
                product /= nums[l++];
            }
            count += r-l+1;
        }
        return count;
    }
}
