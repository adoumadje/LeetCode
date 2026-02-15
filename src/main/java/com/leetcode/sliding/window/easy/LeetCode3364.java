package com.leetcode.sliding.window.easy;

import java.util.List;

public class LeetCode3364 {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int best = Integer.MAX_VALUE;
        for(int w = l; w <= r; ++w) {
            int left = 0;
            int sum = 0;
            for(int right = 0; right < n; ++right) {
                sum += nums.get(right);
                if(right-left+1 < w) {
                    continue;
                } else if (right-left+1 > w) {
                    sum -= nums.get(left);
                    left += 1;
                }
                if(sum > 0) best = Math.min(best, sum);
            }
        }
        return best == Integer.MAX_VALUE ? -1 : best;
    }
}
