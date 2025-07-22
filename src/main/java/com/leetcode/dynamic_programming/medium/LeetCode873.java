package com.leetcode.dynamic_programming.medium;

public class LeetCode873 {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int res = 0;
        for(int i = 2; i < n; ++i) {
            int l = 0, r = i-1;
            while(l < r) {
                int sum = arr[l] + arr[r];
                if(sum == arr[i]) {
                    dp[r][i] = 1 + dp[l][r];
                    res = Math.max(res, dp[r][i] + 2);
                    l++;
                } else if (sum > arr[i]) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }
}
