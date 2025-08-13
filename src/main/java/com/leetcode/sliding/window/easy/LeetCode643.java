package com.leetcode.sliding.window.easy;

public class LeetCode643 {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for(int i = 0; i < k; ++i) {
            sum += nums[i];
        }
        int n = nums.length;
        double res = sum / k;
        for(int i = 1; i < n-k+1; ++i) {
            sum -= nums[i-1];
            sum += nums[i+k-1];
            res = Math.max(res, sum / k);
        }
        return res;
    }
}
