package com.leetcode.dynamic_programming.medium;

import java.util.Arrays;
import java.util.BitSet;

public class LeetCode3685 {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        int n = nums.length;
        boolean[] res = new boolean[n];
        Arrays.sort(nums);
        boolean[] dp = new boolean[k+1];
        dp[0] = true;
        int i = 0;
        for(int x = 1;  x <= n; ++x) {
            for(; i < n && nums[i] < x; ++i) {
                for(int j = k; j >= nums[i]; --j) {
                    dp[j] = dp[j] || dp[j-nums[i]];
                }
            }
            for(int t = 0; t <= n-i && x*t <= k; ++t) {
                if(dp[k-x*t]) {
                    res[x-1] = true;
                    break;
                }
            }
        }
        return res;
    }
}
