package com.leetcode.dynamic_programming.medium;

public class LeetCode1947 {
    int m, n;
    Integer[][] mem, score;
    int[][] students, mentors;

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        this.m = students.length;
        this.n = mentors.length;
        this.mem = new Integer[m][1<<n];
        this.score = new Integer[m][n];
        this.students = students;
        this.mentors = mentors;
        return dfs(0, 0);
    }

    private int dfs(int i, int mask) {
        if(i == m || mask == (1<<n) - 1)
            return 0;
        if(mem[i][mask] != null) return mem[i][mask];
        int res = 0;
        for(int j = 0; j < n; ++j) {
            if(((1<<j) & mask) == 0) {
                int newMask = mask | (1 << j);
                res = Math.max(res, getScore(i, j) + dfs(i+1, newMask));
            }
        }
        return mem[i][mask] = res;
    }

    private int getScore(int i, int j) {
        if(score[i][j] != null) return score[i][j];
        int len = students[i].length;
        int counter = 0;
        for(int k = 0; k < len; ++k) {
            if(students[i][k] == mentors[j][k])
                ++counter;
        }
        return score[i][j] = counter;
    }
}
