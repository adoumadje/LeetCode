package com.leetcode.dynamic_programming.medium;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode1024 {
    public int videoStitching(int[][] clips, int time) {
        int count  = 0;
        int prev = 0, curr = 0;
        Comparator<int[]> comparator = Comparator.comparingInt(a -> a[0]);
        Arrays.sort(clips, comparator);
        for(int[] clip: clips) {
            if(clip[0] > curr) return -1;
            if(clip[0] > prev) {
                ++count;
                prev = curr;
            }
            curr = Math.max(curr, clip[1]);
            if(curr >= time) {
                return curr > prev ? count + 1 : count;
            }
        }
        if(curr < time) return -1;
        if(curr > prev) ++count;
        return count;
    }
}
