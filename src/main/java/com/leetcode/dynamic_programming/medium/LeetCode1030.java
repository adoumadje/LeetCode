package com.leetcode.dynamic_programming.medium;

import java.util.Stack;

public class LeetCode1030 {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(int x: arr) {
            if(stack.isEmpty() || (!stack.isEmpty() && stack.peek() >= x)) {
                stack.push(x);
            } else {
                while (!stack.isEmpty() && stack.peek() < x) {
                    int curr = stack.pop();
                    sum += stack.isEmpty() ? curr * x : Math.min(curr * stack.peek(), curr * x);
                }
                stack.push(x);
            }
        }
        int prev = stack.pop();
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            sum += prev * curr;
            prev = curr;
        }
        return sum;
    }
}
