package com.leetcode.dynamic_programming.medium.leetcode2400;

public class LeetCode2400DP {
    public int numberOfWays(int startPos, int endPos, int k) {
        startPos += k;
        endPos += k;
        int n = endPos + k + 1;
        long MOD = (long) (1e9+7);
        long[] prev = new long[n];
        prev[startPos] = 1;
        for(int kk = 1; kk <= k; ++kk) {
            long[] curr = new long[n];
            for(int i = 0; i < n; ++i) {
                if(i-1 >= 0) curr[i] += prev[i-1];
                if(i+1 < n) curr[i] += prev[i+1];
                curr[i] %= MOD;
            }
            prev = curr;
        }
        return (int) prev[endPos];
    }
}
