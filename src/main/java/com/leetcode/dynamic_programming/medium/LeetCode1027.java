package com.leetcode.dynamic_programming.medium;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1027 {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer>[] dp = new Map[n];
        dp[0] = new HashMap<>();
        int res = 0;
        for(int i = 1; i < n; ++i) {
            dp[i] = new HashMap<>();
            for(int j = i-1; j >= 0; --j) {
                int diff = nums[i] - nums[j];
                int finalJ = j;
                dp[i].compute(diff, (k, v) -> {
                    int prev = dp[finalJ].getOrDefault(diff, 0);
                    v = v == null ? prev + 1 : Math.max(v, prev + 1);
                    return v;
                });
                res = Math.max(res, dp[i].get(diff) + 1);
            }
        }
        return res;
    }
}
