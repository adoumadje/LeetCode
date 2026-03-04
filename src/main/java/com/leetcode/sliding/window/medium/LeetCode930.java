package com.leetcode.sliding.window.medium;

public class LeetCode930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int prefix = 0, n = nums.length;
        int[] freq = new int[n+1];
        freq[0] = 1;
        int count = 0;
        for(int x: nums) {
            prefix += x;
            if(prefix >= goal) {
                count += freq[prefix-goal];
            }
            freq[prefix] += 1;
        }
        return count;
    }
}
