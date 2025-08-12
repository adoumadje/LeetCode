package com.leetcode.dynamic_programming.medium;

public class LeetCode1049 {
    public int lastStoneWeightII(int[] stones) {
        boolean[] dp = new boolean[1501];
        dp[0] = true;
        int sum = 0;
        for(int stone: stones) {
            sum += stone;
            for(int i = Math.min(1500, sum); i >= stone; --i) {
                dp[i] |= dp[i-stone];
            }
        }
        int closest = 0;
        for(int i = sum/2; i >= 0; --i) {
            if(dp[i]) {
                closest = i;
                break;
            }
        }
        return sum - 2*closest;
    }
}
