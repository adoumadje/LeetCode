package com.leetcode.sliding.window.easy;

public class LeetCode3206 {
    public int numberOfAlternatingGroups(int[] colors) {
        int count = 0;
        int n = colors.length;
        int l, r, index;
        for(int i = 1; i <= n; ++i) {
            l = i-1;
            r = (i+1) % n;
            index = i % n;
            if(colors[index] != colors[l] && colors[index] != colors[r])
                count += 1;
        }
        return count;
    }
}
