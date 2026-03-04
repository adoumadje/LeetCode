package com.leetcode.sliding.window.medium;

public class LeetCode1004 {
    public int longestOnes(int[] nums, int k) {
        int zeros = 0, n = nums.length, l  = 0, res = 0;
        for(int r = 0; r < n; ++r) {
            zeros += nums[r] == 0 ? 1 : 0;
            while (zeros > k) {
                zeros -= nums[l++] == 0 ? 1 : 0;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
