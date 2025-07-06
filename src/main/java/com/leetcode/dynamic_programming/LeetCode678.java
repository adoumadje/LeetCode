package com.leetcode.dynamic_programming;

public class LeetCode678 {
    public boolean checkValidString(String s) {
        int leftMin = 0, leftMax = 0;
        for(char c: s.toCharArray()) {
            if(c == '(') {
                ++leftMin;
                ++leftMax;
            } else if (c == '*') {
                --leftMin;
                ++leftMax;
            } else {
                --leftMin;
                --leftMax;
            }
            if(leftMin < 0) leftMin = 0;
            if(leftMax < 0) return false;
        }
        return leftMin == 0;
    }

}
