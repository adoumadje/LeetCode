package com.leetcode.dynamic_programming.medium;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1824 {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        Queue<int[]> q = new LinkedList<>();
        // {x, y, count}
        q.add(new int[]{0, 2, 0});
        int res = Integer.MAX_VALUE;
        int[] deriv = {1, 2, -1, -2};
        while (!q.isEmpty()) {
            int qs = q.size();
            while (qs-- > 0) {
                int[] curr = q.poll();
                int x = curr[0], y = curr[1], count = curr[2];
                if(x == n-1) {
                    res = Math.min(res, count);
                } else {
                    if(obstacles[x+1] != y) {
                        q.add(new int[]{x+1, y, count});
                    } else {
                        for(int dy: deriv) {
                            int ny = y + dy;
                            if(ny > 0 && ny < 4 && obstacles[x] != ny) {
                                q.add(new int[]{x, ny, 1 + count});
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
