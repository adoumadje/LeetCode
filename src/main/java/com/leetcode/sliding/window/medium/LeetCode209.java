package com.leetcode.sliding.window.medium;

public class LeetCode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l = 0, sum = 0;
        int res = n+1;
        for(int r = 0; r < n; ++r) {
            sum += nums[r];
            if(sum < target) continue;
            while (sum >= target) {
                res = Math.min(res, r-l+1);
                sum -= nums[l++];
            }
        }
        return res > n ? 0 : res;
    }
}
