package com.leetcode.dynamic_programming.medium.leetcode2522;

public class LeetCode2522DP {
    public int minimumPartition(String s, int k) {
        char[] sa = s.toCharArray();
        int len = getLen(k);
        int n = sa.length;
        int[] dp = new int[n+1];
        for(int i = n-1; i >= 0; --i) {
            dp[i] = n+1;
            int curr = 0;
            for(int j = i; j < i+len && j < n; ++j) {
                curr = curr * 10 + (sa[j] - '0');
                if(curr <= k)
                    dp[i] = Math.min(dp[i], 1 + dp[j+1]);
            }
            if(dp[i] > n) return -1;
        }
        return dp[0];
    }

    private int getLen(int x) {
        int len = 1;
        while ((x /= 10) > 0) ++len;
        return len;
    }
}
