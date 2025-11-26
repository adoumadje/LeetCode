package com.leetcode.dynamic_programming.medium;

import java.util.List;

public class LeetCode2826 {
    public int minimumOperations(List<Integer> nums) {
        int[] dp = new int[4];
        for(int x: nums) {
            dp[x] += 1;
            dp[2] = Math.max(dp[2], dp[1]);
            dp[3] = Math.max(dp[3], dp[2]);
        }
        return nums.size() - dp[3];
    }
}
