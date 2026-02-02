package com.leetcode.sliding.window.easy;

public class LeetCode2379 {
    public int minimumRecolors(String blocks, int k) {
        char[] ba = blocks.toCharArray();
        int n = ba.length;
        int white = 0, res = n;
        int left = 0;
        for(int right = 0; right < n; ++right) {
            if(ba[right] == 'W') white += 1;
            int win = right-left+1;
            if(win == k) {
                res = Math.min(res, white);
            } else if (win > k) {
                if(ba[left] == 'W') white -= 1;
                left += 1;
                res = Math.min(res, white);
            }
        }
        return res;
    }
}
