package com.leetcode.dynamic_programming.medium;

import java.util.List;

public class LeetCode2063 {
    public long countVowels(String word) {
        char[] wa = word.toCharArray();
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        int n = wa.length;
        long counter = 0;
        for(int i = 0; i < n; ++i) {
            if(vowels.contains(wa[i])) {
                counter += (long) (i + 1) * (n-i);
            }
        }
        return counter;
    }
}
