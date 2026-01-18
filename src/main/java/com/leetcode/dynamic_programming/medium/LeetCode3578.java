package com.leetcode.dynamic_programming.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode3578 {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long MOD = (long) 1e9 + 7;
        Deque<int[]> maxQ = new ArrayDeque<>();
        Deque<int[]> minQ = new ArrayDeque<>();
        int left = 0;
        // 0: empty, 1: first element
        long[] dp = new long[n+1];
        // 0: before empty, 1: empty, 2: first element
        long[] prefix = new long[n+2];
        dp[0] = prefix[1] = 1;
        for(int right = 0; right < n; ++right) {
            int x = nums[right];
            while (!maxQ.isEmpty() && maxQ.peekLast()[1] < x)
                maxQ.pollLast();
            maxQ.offerLast(new int[]{right, x});
            while (!minQ.isEmpty() && minQ.peekLast()[1] > x)
                minQ.pollLast();
            minQ.offerLast(new int[]{right, x});
            int delta = maxQ.peekFirst()[1] - minQ.peekFirst()[1];
            while (delta > k) {
                if(maxQ.peekFirst()[0] == left)
                    maxQ.pollFirst();
                if(minQ.peekFirst()[0] == left)
                    minQ.pollFirst();
                left += 1;
                delta = maxQ.peekFirst()[1] - minQ.peekFirst()[1];
            }
            dp[right+1] = (prefix[right+1] - prefix[left] + MOD) % MOD;
            prefix[right+2] = (prefix[right+1] + dp[right+1]) % MOD;
        }
        return (int) dp[n];
    }
}
