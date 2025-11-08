package com.leetcode.dynamic_programming.medium;

import java.util.Arrays;

public class LeetCode2501 {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = nums[n-1];
        int[] dp = new int[m+1];
        dp[m] = 1;
        int res = 0;
        for(int i = n-2; i >= 0; --i) {
            int x = nums[i];
            if(x*x >= 0 && x*x <= m) {
                dp[x] = 1 + dp[x*x];
            } else {
                dp[x] = 1;
            }
            res = Math.max(res, dp[x]);
        }
        return res > 1 ? res : -1;
    }
}
