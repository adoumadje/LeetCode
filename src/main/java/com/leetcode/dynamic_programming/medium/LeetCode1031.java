package com.leetcode.dynamic_programming.medium;

public class LeetCode1031 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; ++i) {
            dp[i] = dp[i-1] + nums[i-1];
        }
        int res = 0;
        int maxFirst = 0;
        for(int i = firstLen; i <= n-secondLen; ++i) {
            maxFirst = Math.max(maxFirst, dp[i] - dp[i-firstLen]);
            int second = dp[i+secondLen] - dp[i];
            res = Math.max(res, maxFirst + second);
        }
        int maxSecond = 0;
        for(int i = secondLen; i <= n-firstLen; ++i) {
            maxSecond = Math.max(maxSecond, dp[i] - dp[i-secondLen]);
            int first = dp[i+firstLen] - dp[i];
            res = Math.max(res, maxSecond + first);
        }
        return res;
    }
}
