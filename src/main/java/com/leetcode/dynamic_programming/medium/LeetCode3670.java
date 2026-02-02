package com.leetcode.dynamic_programming.medium;

public class LeetCode3670 {
    public long maxProduct(int[] nums) {
        int M = 0;
        for(int x: nums) {
            for(int j = 0; j <= 30; ++j) {
                if((x & (1<<j)) != 0)
                    M = Math.max(M, j+1);
            }
        }
        long[] dp = new long[1<<M];
        for(int x: nums) dp[x] = x;
        for(int i = 1; i < dp.length; ++i) {
            int b = i;
            while (b > 0) {
                int j = i ^ (b & -b);
                b &= (b-1);
                dp[i] = Math.max(dp[i], dp[j]);
            }
        }
        long res = 0;
        for(int x: nums) {
            int y = (1<<M) - 1;
            res = Math.max(res, x * dp[x ^ y]);
        }
        return res;
    }
}
