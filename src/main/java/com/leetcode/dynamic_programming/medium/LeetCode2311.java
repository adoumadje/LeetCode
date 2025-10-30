package com.leetcode.dynamic_programming.medium;

public class LeetCode2311 {
    public int longestSubsequence(String s, int k) {
        int bit = 1, counter = 0, num = 0;
        for(int i = s.length() - 1; i >= 0; --i) {
            if(s.charAt(i) == '0') {
                ++counter;
                bit = Math.max(bit, 2 * bit);
            } else if (num + bit <= k) {
                ++counter;
                num += bit;
                bit = Math.max(bit, 2 * bit);
            }
        }
        return counter;
    }
}
