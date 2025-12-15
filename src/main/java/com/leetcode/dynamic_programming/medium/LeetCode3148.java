package com.leetcode.dynamic_programming.medium;

import java.util.List;

public class LeetCode3148 {
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size(), n = grid.get(0).size();
        int INF = (int) (-1e5);
        int res = INF, move, curr, bottom, right, next;
        for(int r = m-1; r >= 0; --r) {
            for(int c = n-1; c >= 0; --c) {
                if(r == m-1 && c == n-1) continue;
                move = INF;
                curr = next = grid.get(r).get(c);
                if(c+1 < n) {
                    right = grid.get(r).get(c+1);
                    next = Math.max(next, right);
                    move = Math.max(move, right - curr);
                }
                if(r+1 < m) {
                    bottom = grid.get(r+1).get(c);
                    next = Math.max(next, bottom);
                    move = Math.max(move, bottom - curr);
                }
                grid.get(r).set(c, next);
                res = Math.max(res, move);
            }
        }
        return res;
    }
}
