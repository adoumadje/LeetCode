package com.leetcode.dynamic_programming.medium.leetcode2915;

import java.util.Arrays;
import java.util.List;

public class LeetCode2915DP {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[] dp = new int[target+1];
        int n = nums.size();
        Arrays.fill(dp, -2 * n);
        dp[0] = 0;
        for(int x: nums) {
            for(int t = target; t >= x; --t) {
                dp[t] = Math.max(dp[t], 1 + dp[t-x]);
            }
        }
        return dp[target] < 0 ? -1 : dp[target];
    }
}
