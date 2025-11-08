package com.leetcode.dynamic_programming.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode2420 {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        /**
         * 0: left[n]
         * 1: right[n]
         */
        int[][] dp = new int[2][n];
        for(int i = 0; i < n; ++i) {
            if(i-1 >= 0 && nums[i-1] >= nums[i]) {
                dp[0][i] = 1 + dp[0][i-1];
            } else {
                dp[0][i] = 1;
            }
            int j = n-1-i;
            if(j+1 < n && nums[j+1] >= nums[j]) {
                dp[1][j] = 1 + dp[1][j+1];
            } else {
                dp[1][j] = 1;
            }
        }
        List<Integer> good = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            if(i-1 >= 0 && dp[0][i-1] >= k
            && i+1 < n && dp[1][i+1] >= k)
                good.add(i);
        }
        return good;
    }
}
