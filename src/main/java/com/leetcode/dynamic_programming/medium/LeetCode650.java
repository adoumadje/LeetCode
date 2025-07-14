package com.leetcode.dynamic_programming.medium;

import java.util.Arrays;

public class LeetCode650 {
    public int minSteps(int n) {
        int res = 0;
        for(int i = 2; i <= n;) {
            if(n % i == 0) {
                res += i;
                n /= i;
            } else {
                i++;
            }
        }
        return res;
    }
}
