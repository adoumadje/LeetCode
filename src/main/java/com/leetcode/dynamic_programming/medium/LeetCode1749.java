package com.leetcode.dynamic_programming.medium;

public class LeetCode1749 {
    public int maxAbsoluteSum(int[] nums) {
        int kmax = Integer.MIN_VALUE, kmin = Integer.MAX_VALUE;
        int tmax = 0, tmin = 0;
        for(int x: nums) {
            tmax = Math.max(tmax + x, 0);
            kmax = Math.max(kmax, tmax);

            tmin = Math.min(tmin + x, 0);
            kmin = Math.min(kmin, tmin);
        }
        return Math.max(Math.abs(kmax), Math.abs(kmin));
    }
}
