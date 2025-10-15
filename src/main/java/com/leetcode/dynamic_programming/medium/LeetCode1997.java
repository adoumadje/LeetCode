package com.leetcode.dynamic_programming.medium;

public class LeetCode1997 {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        int[] dp = new int[n];
        int MOD = (int) (1e9 + 7);
        for(int i = 1; i < n; ++i) {
            int next = nextVisit[i-1];
            int steps = dp[i-1] + 1 + (dp[i-1] - dp[next]) + 1;
            dp[i] = steps < 0 ? (steps + MOD) % MOD : steps % MOD;
        }
        return dp[n-1];
    }
}
