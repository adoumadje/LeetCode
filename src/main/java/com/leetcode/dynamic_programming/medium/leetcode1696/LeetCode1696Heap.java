package com.leetcode.dynamic_programming.medium.leetcode1696;

import java.util.PriorityQueue;

public class LeetCode1696Heap {
    public int maxResult(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a1, a2) -> Integer.compare(a2[1], a1[1]));
        int n = nums.length;
        maxHeap.add(new int[]{0, nums[0]});
        for(int i = 1; i < n; ++i) {
            while (i - maxHeap.peek()[0] > k) maxHeap.poll();
            nums[i] +=  maxHeap.peek()[1];
            maxHeap.add(new int[]{i, nums[i]});
        }
        return nums[n-1];
    }
}
