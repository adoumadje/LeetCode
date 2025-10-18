package com.leetcode.dynamic_programming.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode2008 {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] ride: rides) {
            map.computeIfAbsent(ride[1], k -> new ArrayList<>());
            map.get(ride[1]).add(ride);
        }
        long[] dp = new long[n+1];
        for(int i = 1; i <= n; ++i) {
            if(!map.containsKey(i)) {
                dp[i] = dp[i-1];
                continue;
            }
            for(int[] ride: map.get(i)) {
                int st = ride[0], v = ride[1] - ride[0] + ride[2];
                dp[i] = max(dp[i], dp[i-1], dp[st] + v);
            }
        }
        return dp[n];
    }

    private long max(long... arr) {
        long m = Long.MIN_VALUE;
        for(long x: arr) m = Math.max(m, x);
        return m;
    }
}
