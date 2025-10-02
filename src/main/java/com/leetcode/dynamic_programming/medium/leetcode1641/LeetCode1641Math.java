package com.leetcode.dynamic_programming.medium.leetcode1641;

public class LeetCode1641Math {
    public int countVowelStrings(int n) {
        return (n+4) * (n+3) * (n+2) * (n+1) / 24;
    }
}
