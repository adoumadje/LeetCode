package com.leetcode.dynamic_programming.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode907 {
    int MOD = (int) 1e9 + 7;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Deque<int[]> deque = new ArrayDeque<>();
        long sum = 0;
        for(int i = 0; i < n; ++i) {
            int left = 0;
            if(deque.isEmpty()) {
                left = i+1;
            } else {
                int count = 0;
                while (!deque.isEmpty() && deque.peekLast()[0] >= arr[i]) {
                    int[] curr = deque.removeLast();
                    left = curr[2];
                    int right = count;
                    sum += (long) left * right * curr[0];
                    ++count;
                }
                if(deque.isEmpty()) {
                    left = i+1;
                } else {
                    left = i - deque.peekLast()[1];
                }
            }
            deque.add(new int[]{arr[i], i, left});
        }
        int right = 0;
        while(!deque.isEmpty()) {
            int[] curr = deque.removeLast();
            int left = curr[2];
            sum += (long) left * right * curr[0];
            right++;
        }
        return (int)(sum % MOD);
    }
}
