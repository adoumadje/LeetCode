package com.leetcode.daily.Y2025.july;

import java.util.HashSet;
import java.util.Set;

public class LeetCode3487 {
    public int maxSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            max = Math.max(max, num);
            if(num >= 0) {
                set.add(num);
            }
        }
        max = set.isEmpty() ? max
                : set.stream().reduce(Integer::sum).get();
        return max;
    }
}
