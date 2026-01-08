package com.leetcode.dynamic_programming.medium;

import java.util.HashSet;
import java.util.Set;

public class LeetCode3434 {
    public int maxFrequency(int[] nums, int k) {
        Set<Integer> unique = new HashSet<>();
        int kCount = 0;
        for(int x: nums) {
            if(x == k) kCount += 1;
            unique.add(x);
        }
        int res = kCount;
        for(int x: unique) {
            if(x == k) continue;
            int kadane = 0;
            int best = 0;
            for(int y: nums) {
                if(y == x) {
                    kadane += 1;
                } else if (y == k) {
                    kadane -= 1;
                }
                if(kadane < 0) kadane = 0;
                best = Math.max(best, kadane);
            }
            res = Math.max(res, kCount + best);
        }
        return res;
    }
}
