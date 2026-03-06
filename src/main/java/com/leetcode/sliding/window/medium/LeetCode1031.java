package com.leetcode.sliding.window.medium;

public class LeetCode1031 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        /**
         * 0: first, 1: bestFirst, 2: second, 3: bestSecond;
         */
        int[][] dp = new int[4][n+1];
        int r1 = n-1, r2 = n-1;
        int first = 0, second = 0;
        int res = 0;
        for(int l = n-1; l >= 0; --l) {
            first += nums[l];
            second += nums[l];
            if(r1-l+1 >= firstLen) {
                if(r1-l+1 > firstLen) {
                    first -= nums[r1--];
                }
                dp[0][l] = first;
                dp[1][l] = Math.max(first, dp[1][l+1]);
                res = Math.max(res, first+ dp[3][r1+1]);
            }
            if(r2-l+1 >= secondLen) {
                if(r2-l+1 > secondLen) {
                    second -= nums[r2--];
                }
                dp[2][l] = second;
                dp[3][l] = Math.max(second, dp[3][l+1]);
                res = Math.max(res, second+ dp[1][r2+1]);
            }
        }
        return res;
    }
}
