package com.leetcode.dynamic_programming.medium.leetcode2369;

public class LeetCode2369DP {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 2; i <= n; ++i) {
            int j = i-1;
            dp[i] = dp[i] || (nums[j] == nums[j-1] && dp[i-2]);
            if(i >= 3) {
                dp[i] = dp[i] || (((nums[j] == nums[j-1] && nums[j-1] == nums[j-2])
                || (nums[j] == 1 + nums[j-1] && nums[j-1] == 1 + nums[j-2])) && dp[i-3]);
            }
        }
        return dp[n];
    }
}
