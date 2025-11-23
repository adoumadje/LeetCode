package com.leetcode.dynamic_programming.medium.leetcode2786;

public class LeetCode2786DP {
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long res;
        long odd = nums[0] % 2 == 1 ? nums[0] : nums[0] - x;
        long even = nums[0] % 2 == 0 ? nums[0] : nums[0] - x;
        for(int i = 1; i < n; ++i) {
            if(nums[i] % 2 == 0) {
                even = Math.max(even + nums[i], odd + nums[i] - x);
            } else {
                odd = Math.max(odd + nums[i], even + nums[i] - x);
            }
        }
        return Math.max(odd, even);
    }
}
