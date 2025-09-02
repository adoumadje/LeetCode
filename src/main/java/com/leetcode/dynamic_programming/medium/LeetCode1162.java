package com.leetcode.dynamic_programming.medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.BiPredicate;

public class LeetCode1162 {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        for(int r = 0; r < n; ++r) {
            for(int c = 0; c < n; ++c) {
                if(grid[r][c] == 1) {
                    q.add(new int[]{r, c});
                }
            }
        }
        BiPredicate<Integer, Integer> withinRange = (r, c) -> Math.min(r, c) >= 0
                && Math.max(r, c) < n;
        int res = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            res = Math.max(res, grid[r][c]);
            for(int[] dir: directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if(withinRange.test(nr, nc) && grid[nr][nc] == 0) {
                    grid[nr][nc] = 1 + grid[r][c];
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return res > 1 ? res - 1 : -1;
    }
}
