package com.leetcode.dynamic_programming.medium.leetcode3186;

import java.util.*;

public class LeetCode3186DP {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer> uniquePower = new ArrayList<>();
        for(int x: power) {
            if(freq.containsKey(x)) {
                freq.compute(x, (k, v) -> v+1);
            } else {
                uniquePower.add(x);
                freq.put(x, 1);
            }
        }
        Collections.sort(uniquePower);
        int n = uniquePower.size();
        long[] dp = new long[n];
        long res = 0;
        for(int i = n-1; i >= 0; --i) {
            for(int j = 1; j <= 3; ++j) {
                if(i+j < n && uniquePower.get(i+j) - uniquePower.get(i) > 2)
                    dp[i] = Math.max(dp[i], dp[i+j]);
            }
            dp[i] += (long) freq.get(uniquePower.get(i)) * uniquePower.get(i);
            if(i+1 < n) dp[i] = Math.max(dp[i], dp[i+1]);
        }
        return dp[0];
    }
}
