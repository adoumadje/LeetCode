package com.leetcode.dynamic_programming.medium.leetcode678;

import java.util.Stack;

public class LeetCode678Stack {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();
        int n = s.length();
        for(int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if(ch == '(') {
                open.push(i);
            } else if (ch == '*') {
                star.push(i);
            } else {
                if(!open.isEmpty()) {
                    open.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }
        while (!open.isEmpty() && !star.isEmpty()) {
            int op = open.pop();
            int st = star.pop();
            if(op > st) return false;
        }
        return open.isEmpty();
    }
}
