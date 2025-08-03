package com.leetcode.dynamic_programming.medium;

public class LeetCode1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int res = 0;
        int prev = values[0] - 1;
        for(int j = 1; j < n; ++j) {
            res = Math.max(res, prev + values[j]);
            prev = Math.max(prev, values[j]) - 1;
        }
        return res;
    }
}
