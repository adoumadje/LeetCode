package com.leetcode.dynamic_programming.medium;

public class LeetCode1525 {
    public int numSplits(String s) {
        int[] alphLeft = new int[26];
        int[] alphRight = new int[26];
        int n = s.length();
        int fl = s.charAt(0) - 'a';
        alphLeft[fl] = 1;
        int fr = s.charAt(n-1) - 'a';
        alphRight[fr] = 1;
        int[] left = new int[n];
        left[0] = 1;
        int[] right = new int[n];
        right[n-1] = 1;
        for(int i = 1; i < n; ++i) {
            int j = n-1-i;
            int x = s.charAt(i) - 'a';
            int y = s.charAt(n-1-i) - 'a';
            if(alphLeft[x] == 0) {
                left[i] = 1 + left[i-1];
                ++alphLeft[x];
            } else {
                left[i] = left[i-1];
            }
            if(alphRight[y] == 0) {
                right[j] = 1 + right[j+1];
                ++alphRight[y];
            } else {
                right[j] = right[j+1];
            }
        }
        int counter = 0;
        for(int i = 0; i+1 < n; ++i) {
            if(left[i] == right[i+1]) ++counter;
        }
        return counter;
    }
}
