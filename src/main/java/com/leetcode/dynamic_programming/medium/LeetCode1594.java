package com.leetcode.dynamic_programming.medium;

public class LeetCode1594 {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long MOD = (long) (1e9) + 7;
        long[][][] dp = new long[m][n][2];
        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];
        for(int r = 0; r < m; ++r) {
            for(int c = 0; c < n; ++c) {
                if(r == 0 && c == 0) continue;
                int curr = grid[r][c];
                long currMax = 0, currMin = 0;
                long[] prevLeft, prevTop;
                if (r == 0) {
                    prevLeft = dp[r][c-1];
                    currMax = Math.max(curr * prevLeft[0], curr * prevLeft[1]);
                    currMin = Math.min(curr * prevLeft[0], curr * prevLeft[1]);
                } else if(c == 0) {
                    prevTop = dp[r-1][c];
                    currMax = Math.max(curr * prevTop[0], curr * prevTop[1]);
                    currMin = Math.min(curr * prevTop[0], curr * prevTop[1]);
                } else {
                    prevLeft = dp[r][c-1];
                    prevTop = dp[r-1][c];
                    currMax = Math.max(Math.max(curr * prevLeft[0], curr * prevLeft[1]),
                            Math.max(curr * prevTop[0], curr * prevTop[1]));
                    currMin = Math.min(Math.min(curr * prevLeft[0], curr * prevLeft[1]),
                            Math.min(curr * prevTop[0], curr * prevTop[1]));
                }
                dp[r][c] = new long[] {currMax, currMin};
            }
        }
        int res = (int) (dp[m-1][n-1][0] % MOD);
        return Math.max(-1, res);
    }
}
