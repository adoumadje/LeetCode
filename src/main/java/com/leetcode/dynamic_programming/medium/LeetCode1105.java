package com.leetcode.dynamic_programming.medium;

public class LeetCode1105 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; ++i) {
            int maxH = Integer.MIN_VALUE;
            dp[i] = Integer.MAX_VALUE;
            int space = shelfWidth;
            for(int j = i; j > 0; --j) {
                space -= books[j-1][0];
                if(space < 0) break;
                maxH = Math.max(maxH, books[j-1][1]);
                dp[i] = Math.min(dp[i], maxH + dp[j-1]);
            }
        }
        return dp[n];
    }
}
