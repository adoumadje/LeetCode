package com.leetcode.dynamic_programming.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode1871 {
    public boolean canReach(String s, int minJump, int maxJump) {
        char[] sa = s.toCharArray();
        int n = sa.length;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        for(int i = 1; i < n; ++i) {
            int d = i - deque.peekFirst();
            if(d >= minJump && d <= maxJump && sa[i] == '0') {
                deque.offerLast(i);
                if(i == n-1) return true;
            }
            if(d == maxJump) deque.removeFirst();
            if(deque.isEmpty()) break;
        }
        return false;
    }
}
