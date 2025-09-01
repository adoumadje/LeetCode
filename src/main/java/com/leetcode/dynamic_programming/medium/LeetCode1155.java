package com.leetcode.dynamic_programming.medium;

public class LeetCode1155 {
    public int numRollsToTarget(int n, int k, int target) {
        long MOD = (long) 1e9 + 7;
        int[] prev = new int[target+1];
        int[] curr = new int[target+1];
        prev[0] = 1;
        for(int i = 1; i <= n; ++i) {
            for(int t = 1; t <= target; ++t) {
                long possibilities = 0;
                for(int x = 1; x <= k; ++x) {
                    if(t-x >= 0) {
                        possibilities += prev[t-x];
                    }
                }
                curr[t] = (int) (possibilities % MOD);
            }
            prev = curr.clone();
        }
        return curr[target];
    }
}

