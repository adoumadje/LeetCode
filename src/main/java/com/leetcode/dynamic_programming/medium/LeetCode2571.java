package com.leetcode.dynamic_programming.medium;

public class LeetCode2571 {
    public int minOperations(int n) {
        int m = 32;
        int[] bin = new int[m+2];
        int op = 0, len = 0;
        for(int i = 0; i < m; ++i) {
            bin[i] = ((1<<i) & n) != 0 ? 1 : 0;
        }
        for (int b : bin) {
            if (b == 1) {
                ++len;
            } else if (len == 1) {
                op += 1;
                len = 0;
            } else if (len > 1) {
                op += 1;
                len = 1;
            }
        }
        return op;
    }
}
