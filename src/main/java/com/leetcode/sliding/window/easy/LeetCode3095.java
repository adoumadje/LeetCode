package com.leetcode.sliding.window.easy;

public class LeetCode3095 {
    public int minimumSubarrayLength(int[] nums, int k) {
        int M = 6, n = nums.length;
        int[] freq = new int[M];
        int or = 0;
        int l = 0, res = n+1;
        for(int r = 0; r < n; ++r) {
            or = operation(freq, nums[r], true);
            while (l <= r && or >= k) {
                res = Math.min(res, r-l+1);
                or = operation(freq, nums[l], false);
                l += 1;
            }
        }
        return res > n ? -1 : res;
    }

    private int operation(int[] freq, int num, boolean add) {
        int M = freq.length;
        int or = 0;
        for(int i = 0; i < M; ++i) {
            if((num & (1<<i)) != 0) {
                freq[i] += add ? 1 : -1;
            }
            or |= freq[i] > 0 ? 1<<i : 0;
        }
        return or;
    }
}
