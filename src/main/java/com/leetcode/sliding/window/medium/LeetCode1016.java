package com.leetcode.sliding.window.medium;

public class LeetCode1016 {
    public boolean queryString(String s, int n) {
        for(int i = 1; i <= n; ++i) {
            if(!s.contains(binary(i))) return false;
        }
        return true;
    }

    private CharSequence binary(int i) {
        StringBuilder sb = new StringBuilder();
        while (i > 0) {
            sb.append(1&i);
            i >>= 1;
        }
        return sb.reverse();
    }
}
