package com.leetcode.dynamic_programming.medium;

public class LeetCode1638 {
    public int countSubstrings(String s, String t) {
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        int m = sa.length, n = ta.length;
        int count = 0;
        int[][] zero = new int[m][n];
        int[][] one = new int[m][n];
        for(int j = 0; j < n; ++j) {
            zero[m-1][j] = sa[m-1] == ta[j] ? 1 : 0;
            one[m-1][j] = sa[m-1] != ta[j] ? 1 : 0;
            count += one[m-1][j];
        }
        for(int i = 0; i < m-1; ++i) {
            zero[i][n-1] = sa[i] == ta[n-1] ? 1 : 0;
            one[i][n-1] = sa[i] != ta[n-1] ? 1 : 0;
            count += one[i][n-1];
        }
        for(int i = m-2; i >= 0; --i) {
            for(int j = n-2; j >= 0; --j) {
                if(sa[i] == ta[j]) {
                    zero[i][j] = 1 + zero[i+1][j+1];
                    one[i][j] = one[i+1][j+1];
                } else {
                    one[i][j] = 1 + zero[i+1][j+1];
                }
                count += one[i][j];
            }
        }
        return count;
    }
}
