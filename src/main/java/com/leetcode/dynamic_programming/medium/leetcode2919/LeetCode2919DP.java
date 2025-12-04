package com.leetcode.dynamic_programming.medium.leetcode2919;

import java.util.Arrays;

public class LeetCode2919DP {
    public long minIncrementOperations(int[] nums, int k) {
        int n = nums.length;
        long[] dp = new long[n+1];
        for(int i = n-3; i >= 0; --i) {
            long first = Math.max(0, k - nums[i]) + dp[i+1];
            long second = Math.max(0, k - nums[i+1]) + dp[i+2];
            long third = Math.max(0, k - nums[i+2]) + dp[i+3];
            dp[i] = min(first, second, third);
        }
        return dp[0];
    }

    private long min(long ...arr) {
        return Arrays.stream(arr).min().orElseThrow();
    }
}
