package com.leetcode.dynamic_programming.medium.leetcode1986;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1986OneState {
    int[] tasks;
    List<int[]> mem;
    int n, sessionTime;

    public int minSessions(int[] tasks, int sessionTime) {
        this.n = tasks.length;
        this.sessionTime = sessionTime;
        this.tasks = tasks;
        int capacity = 1<<n;
        this.mem = new ArrayList<>(capacity);
        while (capacity-- > 0) mem.add(null);
        return dfs(0)[0];
    }

    private int[] dfs(int mask) {
        if(mask == (1<<n) - 1) return new int[]{0, 0};
        if(mem.get(mask) != null) return mem.get(mask);
        int session = Integer.MAX_VALUE;
        int time = 0;
        for(int i = 0; i < n; ++i) {
            if((mask & (1<<i)) == 0) {
                int[] next = dfs(mask | (1<<i));
                int currSession = next[0];
                int currTime = next[1];
                if(tasks[i] <= currTime) {
                    currTime -= tasks[i];
                } else {
                    currSession += 1;
                    currTime = sessionTime - tasks[i];
                }

                if(currSession < session || (currSession == session && currTime > time)) {
                    session = currSession;
                    time = currTime;
                }

            }
        }
        mem.set(mask, new int[]{session, time});
        return mem.get(mask);
    }
}
