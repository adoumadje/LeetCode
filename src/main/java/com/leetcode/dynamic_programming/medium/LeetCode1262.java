package com.leetcode.dynamic_programming.medium;

public class LeetCode1262 {
    public int maxSumDivThree(int[] nums) {
        int x0 = 0, x1 = -1, x2 = -1;
        int k = 3;
        for(int x: nums) {
            int nx0, nx1, nx2;
            if(x % k == 0) {
                nx0 = x0 + x;
                nx1 = x1 != -1 ? x1 + x : x1;
                nx2 = x2 != -1 ? x2 + x : x2;
            } else if(x % k == 1) {
                nx0 = x2 != -1 && x2 + x > x0 ? x2 + x : x0;
                nx1 = Math.max(x0 + x, x1);
                nx2 = x1 != -1 && x1 + x > x2 ? x1 + x : x2;
            } else {
                nx0 = x1 != -1 && x1 + x > x0 ? x1 + x : x0;
                nx1 = x2 != -1 && x2 + x > x1 ? x2 + x : x1;
                nx2 = Math.max(x2, x0 + x);
            }
            x0 = nx0;
            x1 = nx1;
            x2 = nx2;
        }
        return x0;
    }
}
