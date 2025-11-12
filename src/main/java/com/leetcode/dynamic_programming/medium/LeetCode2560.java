package com.leetcode.dynamic_programming.medium;

public class LeetCode2560 {
    public int minCapability(int[] nums, int k) {
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        int n = nums.length;
        for(int x: nums) {
            l = Math.min(l, x);
            r = Math.max(r, x);
        }
        int res = -1;
        while(l <= r) {
            int m = l + (r-l) / 2;
            int len = 0;
            for(int i = 0; i < n; ++i) {
                if(nums[i] <= m) {
                    len += 1;
                    i += 1;
                }
            }
            if(len >= k) {
                r = m-1;
                res = m;
            } else {
                l = m+1;
            }
        }
        return res;
    }
}
