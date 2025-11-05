package com.leetcode.dynamic_programming.medium.leetcode2380;

public class LeetCode2380DP {
    public int secondsToRemoveOccurrences(String s) {
        int seconds = 0, zeros = 0;
        for(char ch: s.toCharArray()) {
            if(ch == '0') {
                ++zeros;
            } else if (zeros > 0){
                seconds = Math.max(zeros, 1 + seconds);
            }
        }
        return seconds;
    }
}
