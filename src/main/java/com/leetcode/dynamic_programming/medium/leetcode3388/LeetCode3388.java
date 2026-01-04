package com.leetcode.dynamic_programming.medium.leetcode3388;

public class LeetCode3388 {
    public int beautifulSplits(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int i = n-1; i >= 0; --i) {
            for(int j = i+1; j < n; ++j) {
                if(nums[i] == nums[j])
                    dp[i][j] = 1 + dp[i+1][j+1];
            }
        }
        int beautiful = 0;
        for(int i = 1; i < n; ++i) {
            for(int j = i+1; j < n; ++j) {
                boolean n2 = dp[0][i] >= i && j >= 2*i;
                boolean n3 = dp[i][j] >= j-i;
                if(n2 || n3)
                    beautiful += 1;
            }
        }
        return beautiful;
    }
}
