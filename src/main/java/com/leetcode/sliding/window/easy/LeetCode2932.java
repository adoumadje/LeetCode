package com.leetcode.sliding.window.easy;

import java.util.Arrays;

public class LeetCode2932 {
    public int maximumStrongPairXor(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i+1 < n; ++i) {
            for(int j = i+1; j < n; ++j) {
                if(nums[j] - nums[i] > nums[i]) break;
                res = Math.max(res, nums[i] ^ nums[j]);
            }
        }
        return res;
    }
}
