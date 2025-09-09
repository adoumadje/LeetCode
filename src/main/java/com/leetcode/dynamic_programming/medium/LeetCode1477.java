package com.leetcode.dynamic_programming.medium;

public class LeetCode1477 {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[n];
        int win = 0;
        int l = 0;
        int curr = n+1, res = n+1;
        for(int r = 0; r < n; ++r) {
            win += arr[r];

            while (win > target) {
                win -= arr[l++];
            }

            if(win == target) {
                if(l > 0 && dp[l-1] < n+1) {
                    res = Math.min(res, r-l+1 + dp[l-1]);
                }
                curr = Math.min(curr, r-l+1);
            }
            dp[r] = curr;
        }

        return res <= n ? res : -1;
    }
}
