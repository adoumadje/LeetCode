package com.leetcode.sliding.window.easy;

public class LeetCode3411 {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int res = 1, prod, lcm, gcd;
        for(int i = 0; i + 1 < n; ++i) {
            prod = lcm = gcd = nums[i];
            for(int j = i+1; j < n; ++j) {
                prod *= nums[j];
                gcd = gdc(gcd, nums[j]);
                lcm = lcm(lcm, nums[j]);
                if(prod == lcm * gcd) res = Math.max(res, j-i+1);
            }
        }
        return res;
    }

    private int lcm(int a, int b) {
        return a*b / gdc(a, b);
    }

    private int gdc(int a, int b) {
        return b == 0 ? a : gdc(b, a%b);
    }
}
