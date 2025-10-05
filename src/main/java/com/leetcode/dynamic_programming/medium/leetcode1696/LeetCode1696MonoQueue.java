package com.leetcode.dynamic_programming.medium.leetcode1696;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode1696MonoQueue {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> monoQ = new ArrayDeque<>();
        monoQ.offer(0);
        for(int i = 1; i < n; ++i) {
            nums[i] += nums[monoQ.peekFirst()];
            while (!monoQ.isEmpty() && nums[i] > nums[monoQ.peekLast()])
                monoQ.removeLast();
            monoQ.offerLast(i);
            if(i - monoQ.peekFirst() >= k)
                monoQ.removeFirst();
        }
        return nums[n-1];
    }
}
