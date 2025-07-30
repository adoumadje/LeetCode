package com.leetcode.dynamic_programming.medium;

public class LeetCode926 {
    public int minFlipsMonoIncr(String s) {
        char[] arr = s.toCharArray();
        int total0 = 0, total1 = 0;
        for(char c: arr) total0 += c == '0' ? 1 : 0;
        int curr0 = 0, curr1 = 0;
        int res = total0;
        for(char c: arr) {
            if(c == '0') {
                ++curr0;
            } else {
                ++curr1;
            }
            res = Math.min(res, curr1 + total0 - curr0);
        }
        return res;
    }
}
