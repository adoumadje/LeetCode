package com.leetcode.dynamic_programming.medium;

public class LeetCode1525 {
    public int numSplits(String s) {
        int[] alph = new int[26];
        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 0; i < n; ++i) {
            int j = n-1-i;
            int x = s.charAt(i) - 'a';
            int y = s.charAt(n-1-i) - 'a';
        }
        return 0;
    }
}
