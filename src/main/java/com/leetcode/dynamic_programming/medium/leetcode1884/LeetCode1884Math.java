package com.leetcode.dynamic_programming.medium.leetcode1884;

public class LeetCode1884Math {
    public int twoEggDrop(int n) {
        for(int x = 1; x <= n; ++x)
            if(x*x + x >= 2*n) return x;
        return n;
    }
}
