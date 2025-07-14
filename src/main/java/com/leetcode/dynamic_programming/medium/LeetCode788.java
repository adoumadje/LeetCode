package com.leetcode.dynamic_programming.medium;

import java.util.Arrays;

public class LeetCode788 {
    public int rotatedDigits(int n) {
        int count = 0;
        for(int i = 0; i <= n; ++i) {
            count += checkDigits(i);
        }
        return count;
    }

    private int checkDigits(int num) {
        int counter = 0;
        while (num > 0) {
            int d = num % 10;
            if(d == 3 || d == 4 || d == 7) return 0;
            if(d == 2 || d == 5 || d == 6 || d == 9) {
                ++counter;
            }
            num /= 10;
        }
        return counter > 0 ? 1 : 0;
    }
}
