package com.leetcode.dynamic_programming;

import java.util.Arrays;

public class LeetCode740 {
    public int deleteAndEarn(int[] nums) {
        int m = Arrays.stream(nums).max().getAsInt();
        int[] dp = new int[m+1];
        for(int num: nums) ++dp[num];
        for(int i = 2; i <= m; ++i) {
            dp[i] = Math.max(dp[i-1], i * dp[i] + dp[i-2]);
        }
        return dp[m];
    }
}
