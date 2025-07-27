package com.leetcode.dynamic_programming.medium;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode907 {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<int[]> stack = new Stack<>();
        long[] dp = new long[n];
        for(int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && stack.peek()[0] >= arr[i]) {
                stack.pop();
            }
            int j = stack.isEmpty() ? -1 : stack.peek()[1];
            dp[i] = j == -1 ? arr[i] * (i+1) : dp[j] + arr[i] * (i-j);
            stack.push(new int[]{arr[i], i});
        }
        long MOD = (long) 1e9 + 7;
        long res = Arrays.stream(dp).reduce(0, (a, b) -> (a+b) % MOD);
        return (int)res;
    }
}
