package com.leetcode.dynamic_programming.medium.leetcode2750;

public class LeetCode2750DP {
    public int numberOfGoodSubarraySplits(int[] nums) {
        int n = nums.length;
        long zero = 0;
        long res = 0;
        long total = 1;
        long MOD = (long) (1e9+7);
        for(int i = n-1; i >= 0; --i) {
            if(nums[i] == 0) {
                total = (total%MOD+ zero%MOD)%MOD;
            } else {
                res = total;
                zero = res;
            }
        }
        return (int) res;
    }
}
