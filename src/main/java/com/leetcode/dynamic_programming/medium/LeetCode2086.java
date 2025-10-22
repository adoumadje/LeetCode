package com.leetcode.dynamic_programming.medium;

public class LeetCode2086 {
    public int minimumBuckets(String hamsters) {
        char[] ha = hamsters.toCharArray();
        int n = ha.length;
        int counter = 0;
        for(int i = 0; i < n; ++i) {
            if(ha[i] == 'H') {
                if(i-1 >= 0 && ha[i-1] == '*') {
                    continue;
                } else if (i+1 < n && ha[i+1] == '.') {
                    ha[i+1] = '*';
                    ++counter;
                } else if(i-1 >= 0 && ha[i-1] == '.') {
                    ha[i-1] = '*';
                    ++counter;
                } else {
                    return -1;
                }
            }
        }
        return counter;
    }
}
