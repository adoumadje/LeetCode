package com.leetcode.dynamic_programming.medium.leetcode2957;

public class LeetCode2957DP {
    public int removeAlmostEqualCharacters(String word) {
        char[] wa = word.toCharArray();
        int n = wa.length;
        int[] dp = new int[n+2];
        for(int i = n-2; i >= 0; --i) {
            if(wa[i] == wa[i+1] || Math.abs(wa[i] - wa[i+1]) == 1) {
                dp[i] = 1 + Math.min(dp[i+1], dp[i+2]);
            } else {
                dp[i] = dp[i+1];
            }
        }
        return dp[0];
    }
}
