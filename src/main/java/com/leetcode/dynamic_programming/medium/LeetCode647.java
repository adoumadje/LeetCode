package com.leetcode.dynamic_programming.medium;

public class LeetCode647 {
    char[] s;
    Integer[][] mem;
    public int countSubstrings(String s) {
        this.s = s.toCharArray();
        int n = s.length();
        mem = new Integer[n][n];
        int res = 0;
        for(int i = 0; i < n; ++i) {
            res += 1 + palindrome(i-1, i+1)
                    + palindrome(i, i+1);
        }
        return res;
    }

    private int palindrome(int l, int r) {
        int n = s.length;
        if(l < 0 || r >= n) return 0;
        if(mem[l][r] != null) return mem[l][r];
        int num = 0;
        int ol = l, or = r;
        while(l >= 0 && r < n) {
            if(s[l--] == s[r++]) {
                num++;
            } else {
                break;
            }
        }
        return mem[ol][or] = num;
    }
}
