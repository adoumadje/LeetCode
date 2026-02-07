package com.leetcode.dynamic_programming.medium;

public class LeetCode3738 {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int prev = Integer.MIN_VALUE, pv = 0;
        for(int i = 0; i < n; ++i) {
            dp[i] = nums[i] >= prev ? 1 + pv : 1;
            prev = nums[i];
            pv = dp[i];
        }
        int res = 0;
        for(int i = n-1; i >= 0; --i) {
            int start = i - dp[i] + 1;
            res = Math.max(res, dp[i]);
            if(start-2 >= 0 && nums[start-2] <= nums[start]) {
                res = Math.max(res, dp[i] + dp[start-1]);
            }
            if(start+1 < n && start-1 >= 0 && nums[start-1] <= nums[start+1]) {
                res = Math.max(res, dp[i] + dp[start-1]);
            }
            if(start > 0) {
                res = Math.max(res, dp[i] + 1);
            }
            if(i+1 < n) {
                res = Math.max(res, dp[i] + 1);
            }
        }
        return res;
    }
}
