package com.leetcode.dynamic_programming.medium;

public class LeetCode2645 {
    public int addMinimum(String word) {
        char prev = 'c';
        int counter = 0;
        for(char c: word.toCharArray()) {
            if(c <= prev) counter += 1;
            prev = c;
        }
        return counter * 3 - word.length();
    }
}
