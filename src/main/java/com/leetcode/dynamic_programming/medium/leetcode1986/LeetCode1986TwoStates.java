package com.leetcode.dynamic_programming.medium.leetcode1986;

public class LeetCode1986TwoStates {
    Integer[][] mem;
    int n, sessionTime;
    int[] tasks;
    public int minSessions(int[] tasks, int sessionTime) {
        this.n = tasks.length;
        this.sessionTime = sessionTime;
        this.tasks = tasks;
        this.mem = new Integer[1<<n][sessionTime+1];
        return dfs(0, 0);
    }

    private int dfs(int mask, int time) {
        if(mask == (1 << n) - 1) return 0;
        if(mem[mask][time] != null) return mem[mask][time];
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; ++i) {
            if(((1 << i) & mask) == 0) {
                int newMask = mask | (1<<i);
                if(tasks[i] <= time) {
                    res = min(res, 1 + dfs(newMask, sessionTime - tasks[i]),
                            dfs(newMask, time - tasks[i]));
                } else {
                    res = Math.min(res, 1 + dfs(newMask, sessionTime - tasks[i]));
                }
            }
        }
        return mem[mask][time] = res;
    }

    private int min(int ...arr) {
        int m = Integer.MAX_VALUE;
        for(int x: arr) m = Math.min(m, x);
        return m;
    }
}
