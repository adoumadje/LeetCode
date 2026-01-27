package com.leetcode.dynamic_programming.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LeetCode3654 {
    public long minArraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n+1];
        int[] lastTime = new int[k];
        int[] next = new int[n+1];
        Arrays.fill(next, -1);
        Arrays.fill(lastTime, -n);
        lastTime[0] = 0;
        int start;
        for(int i = 1; i <= n; ++i) {
            prefix[i] = nums[i-1] + prefix[i-1];
            int rem = (int)(prefix[i] % k);
            if((start = lastTime[rem]) >= 0) {
                next[start+1] = i;
            }
            lastTime[rem] = i;
        }
        long sweep = 0;
        long[] dp = new long[n+1];
        for(int i = 0; i <= n; ++i) {
            if(next[i] != -1) {
                dp[next[i]] = prefix[next[i]] - prefix[i-1] + sweep;
            }
            sweep = Math.max(sweep, dp[i]);
        }
        return prefix[n] - sweep;
    }
}
