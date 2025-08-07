package com.leetcode.dynamic_programming.medium;

public class LeetCode1031 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] first = buildDP(nums, firstLen);
        int[] second = buildDP(nums, secondLen);
        int res = 0;
        for(int i = 0; i < n-firstLen+1; ++i) {
            for(int j = 0; j < n-secondLen+1; ++j) {
                if(j + secondLen - 1 < i || j > i + firstLen - 1) {
                    res = Math.max(res, first[i] + second[j]);
                }
            }
        }
        return res;
    }

    private int[] buildDP(int[] nums, int len) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 0; i < len; ++i) {
            dp[0] += nums[i];
        }
        for(int i = 1; i < n-len+1; ++i) {
            dp[i] = dp[i-1] - nums[i-1] + nums[i+len-1];
        }
        return dp;
    }
}
