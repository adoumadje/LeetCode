package com.leetcode.dynamic_programming.medium;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode1696 {
    public int maxResult(int[] nums, int k) {
        int res = Integer.MIN_VALUE;
        int n = nums.length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, nums[0]});
        while (!q.isEmpty()) {
            int len = q.size();
            while (len-- > 0) {
                int[] curr = q.poll();
                if(curr[0] == n-1) {
                    res = Math.max(res, curr[1]);
                }
                for(int i = 1; i <= k; ++i) {
                    int nIdx = curr[0] + i;
                    if(nIdx < n) {
                        q.add(new int[]{nIdx, curr[1] + nums[nIdx]});
                    }
                }
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        return res;
    }
}
