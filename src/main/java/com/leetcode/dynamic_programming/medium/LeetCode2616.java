package com.leetcode.dynamic_programming.medium;

import java.util.Arrays;

public class LeetCode2616 {
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        int r = nums[n-1] - nums[0], l = 0;
        int res = 0;
        while(l <= r) {
            int m = l + (r-l) / 2;
            int counter = 0;
            for(int i = 0; i < n-1; ++i) {
                if(nums[i+1] - nums[i] <= m) {
                    counter += 1;
                    i += 1;
                }
            }
            if(counter >= p) {
                res = m;
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return res;
    }
}
