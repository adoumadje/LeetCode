package com.leetcode.dynamic_programming.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode3751 {
    public int totalWaviness(int num1, int num2) {
        int total = 0;
        for(int num = num1; num <= num2; ++num) {
            total += count(toDigitsArray(num));
        }
        return total;
    }

    private int count(int[] num) {
        int total = 0;
        int n = num.length;
        for(int i = 1; i+1 < n; ++i) {
            if((num[i] - num[i-1]) * (num[i] - num[i+1]) > 0)
                total += 1;
        }
        return total;
    }

    private int[] toDigitsArray(int num) {
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add(num%10);
            num /= 10;
        }
        int n = list.size();
        int[] digits = new int[n];
        for(int i = 0; i < n; ++i) {
            digits[i] = list.get(n-1-i);
        }
        return digits;
    }
}
