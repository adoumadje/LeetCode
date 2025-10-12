package com.leetcode.dynamic_programming.medium;

import java.util.*;

public class LeetCode1976 {
    public int countPaths(int n, int[][] roads) {
        List<List<long[]>> graph = makeAdjacency(n, roads);
        /**
         *  [0: [dist],
         *   1: [count]]
         */
        long[][] shortest = new long[n][2];
        shortest[0][0] = 0;
        shortest[0][1] = 1;
        for(int i = 1; i < n; ++i) shortest[i][0] = Long.MAX_VALUE;
        PriorityQueue<long[]> minHeap = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        minHeap.offer(new long[]{0, 0});
        long MOD = (long) (1e9 + 7);
        while (!minHeap.isEmpty()) {
            long[] curr = minHeap.poll();
            int u = (int) curr[0];
            long ut = curr[1];
            for(long[] nei: graph.get(u)) {
                int v = (int) nei[0];
                long vt = nei[1];
                long alt = ut + vt;

                if(alt < shortest[v][0]) {
                    minHeap.offer(new long[]{v, alt});
                    shortest[v][0] = alt;
                    shortest[v][1] = shortest[u][1];
                } else if (alt == shortest[v][0]) {
                    shortest[v][1] = (shortest[v][1] + shortest[u][1]) % MOD;
                }

            }
        }
        return (int) (shortest[n-1][1] % MOD);
    }

    private List<List<long[]>> makeAdjacency(int n, int[][] roads) {
        List<List<long[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            graph.add(new ArrayList<>());
        for(int[] road: roads) {
            int u = road[0], v = road[1], t = road[2];
            graph.get(u).add(new long[]{v, t});
            graph.get(v).add(new long[]{u, t});
        }
        return graph;
    }
}
