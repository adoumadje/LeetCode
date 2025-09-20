package com.leetcode.dynamic_programming.medium;

public class LeetCode1567 {
    public int getMaxLen(int[] nums) {
        int pos = 0, neg = 0, res = 0;
        for(int x: nums) {
            if(x > 0) {
                ++pos;
                neg += neg == 0 ? 0 : 1;
            } else if (x < 0) {
                int temp = pos + 1;
                pos = neg > 0 ? neg + 1 : 0;
                neg = temp;
            } else {
                pos = 0;
                neg = 0;
            }
            res = Math.max(res, pos);
        }
        return res;
    }
}
