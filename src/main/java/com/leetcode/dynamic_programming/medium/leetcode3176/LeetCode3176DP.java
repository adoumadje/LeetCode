package com.leetcode.dynamic_programming.medium.leetcode3176;

public class LeetCode3176DP {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length, res = 0;
        int[] prev = new int[n], curr;
        for(int kk = 0; kk <= k; ++kk) {
            curr = new int[n];
            for(int i = n-1; i >= 0; --i) {
                curr[i] = 1;
                for(int j = i+1; j < n; ++j) {
                    if(nums[i] == nums[j]) {
                        curr[i] = Math.max(curr[i], 1 + curr[j]);
                    } else if (kk > 0) {
                        curr[i] = Math.max(curr[i], 1 + prev[j]);
                    }
                }
                if(kk == k) res = Math.max(res, curr[i]);
            }
            prev = curr;
        }
        return res;
    }
}
