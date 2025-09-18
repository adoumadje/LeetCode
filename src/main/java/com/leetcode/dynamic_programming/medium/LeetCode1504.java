package com.leetcode.dynamic_programming.medium;

import java.util.Stack;

public class LeetCode1504 {
    public int numSubmat(int[][] mat) {
        Stack<int[]> mono;
        int m = mat.length;
        int n = mat[0].length;
        int res = 0;
        for(int r = 0; r < m; ++r) {
            mono = new Stack<>();
            mono.push(new int[]{-1, -1, 0});
            for(int c = 0; c < n; ++c) {
                if(r > 0 && mat[r][c] == 1) {
                    mat[r][c] = 1 + mat[r-1][c];
                }
                int h = mat[r][c];
                while(h <= mono.peek()[1]) mono.pop();
                int l = c - mono.peek()[0];
                int count = l * h + mono.peek()[2];
                res += count;
                mono.push(new int[]{c, h, count});
            }
        }
        return res;
    }
}
