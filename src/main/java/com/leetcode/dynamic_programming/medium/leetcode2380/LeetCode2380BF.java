package com.leetcode.dynamic_programming.medium.leetcode2380;

public class LeetCode2380BF {
    public int secondsToRemoveOccurrences(String s) {
        if(s.contains("01"))
            return 1 + secondsToRemoveOccurrences(s.replaceAll("01", "10"));
        return 0;
    }
}
