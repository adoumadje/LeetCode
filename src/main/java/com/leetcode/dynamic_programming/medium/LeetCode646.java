package com.leetcode.dynamic_programming.medium;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode646 {
    public int findLongestChain(int[][] pairs) {
        Comparator<int[]> comparator = (a, b) -> Integer.compare(a[0], b[0]);
        Arrays.sort(pairs, comparator);
        int end = -1001;
        int count = 0;
        for(int[] p: pairs) {
            if(p[0] > end) {
                count++;
                end = p[1];
            } else {
                end = Math.min(end, p[1]);
            }
        }
        return count;
    }
}
