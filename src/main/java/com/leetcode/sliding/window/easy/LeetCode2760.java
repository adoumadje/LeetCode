package com.leetcode.sliding.window.easy;

public class LeetCode2760 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int res = 0, n = nums.length;
        int l = -1;
        boolean searching = true;
        for(int r = 0; r < n; ++r) {
            if(searching) {
                if(nums[r] <= threshold && nums[r] % 2 == 0) {
                    l = r;
                    res = Math.max(res, 1);
                    searching = false;
                }
            } else {
                if(nums[r] <= threshold && nums[r] % 2 != nums[r-1] % 2) {
                    res = Math.max(res, r-l+1);
                } else if(nums[r] <= threshold && nums[r] % 2 == 0) {
                    l = r;
                } else {
                    searching = true;
                }
            }
        }
        return res;
    }
}
