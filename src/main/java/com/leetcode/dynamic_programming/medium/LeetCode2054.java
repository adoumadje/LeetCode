package com.leetcode.dynamic_programming.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LeetCode2054 {
    public int maxTwoEvents(int[][] events) {
        List<int[]> points = new ArrayList<>();
        for(int[] event: events) {
            int st = event[0], end = event[1], val = event[2];
            points.add(new int[]{st, 1, val});
            points.add(new int[]{end + 1, -1, val});
        }
        Comparator<int[]> comparator = (a, b) -> {
            if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        };
        points.sort(comparator);
        int currMax = 0, maxSeen = 0;
        for(int[] pt: points) {
            if(pt[1] == 1) {
                currMax = Math.max(currMax, pt[2] + maxSeen);
            } else {
                maxSeen = Math.max(maxSeen, pt[2]);
            }
        }
        return currMax;
    }
}
