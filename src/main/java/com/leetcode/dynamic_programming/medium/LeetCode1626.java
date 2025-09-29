package com.leetcode.dynamic_programming.medium;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode1626 {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] dp = new int[n][3];
        for(int i = 0; i < n; ++i) {
            dp[i] = new int[]{ages[i], scores[i], scores[i]};
        }
        Comparator<int[]> comparator = (a, b) -> {
            if(a[0] == b[0])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        };
        Arrays.sort(dp, comparator);
        int res = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = i-1; j >= 0; --j) {
                if(dp[j][1] <= dp[i][1]) {
                    dp[i][2] = Math.max(dp[i][2], dp[i][1] + dp[j][2]);
                }
            }
            res = Math.max(res, dp[i][2]);
        }
        return res;
    }
}
