package com.leetcode.dynamic_programming.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode3660 {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        List<Integer> left = new ArrayList<>();
        List<Integer> minLeft = new ArrayList<>();
        int max = -1;
        for(int i = 0; i < n; ++i) {
            int x = nums[i];
            if(x > max) {
                max = x;
                left.add(i);
                minLeft.add(x);
            }
            res[i] = nums[left.getLast()];
            minLeft.set(minLeft.size()-1, Math.min(minLeft.getLast(), x));
        }
        for(int i = left.size() - 2; i >= 0; --i) {
            int i1 = left.get(i), i2 = left.get(i+1);
            int min1 = minLeft.get(i), min2 = minLeft.get(i+1);
            if(nums[i1] <= min2) continue;
            for(int j = i1; j < i2; ++j) {
                res[j] = res[i2];
            }
            minLeft.set(i, Math.min(min1, min2));
        }
        return res;
    }
}
