package com.leetcode.dynamic_programming.medium.leetcode678;

public class LeetCode678Greedy {
    public boolean checkValidString(String s) {
        int open = 0;
        int openMax = 0;
        for(char ch: s.toCharArray()) {
            if(ch == '(') {
                openMax += 1;
                open += 1;
            } else if (ch == '*') {
                openMax += 1;
                if(open > 0) open -= 1;
            } else {
                openMax -= 1;
                if(open > 0) open -= 1;
            }
            if(openMax < 0) return false;
        }
        return open == 0;
    }
}
