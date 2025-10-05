package com.leetcode.dynamic_programming.medium;

import java.util.*;

public class LeetCode1786 {
    public int countRestrictedPaths(int n, int[][] edges) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] edge: edges) {
            adj.compute(edge[0], (k, v) -> {
                if(v == null)
                    v = new ArrayList<>();
                v.add(new int[]{edge[1], edge[2]});
                return v;
            });
            adj.compute(edge[1], (k, v) -> {
                if(v == null)
                    v = new ArrayList<>();
                v.add(new int[]{edge[0], edge[2]});
                return v;
            });
        }
        int[] shortest = dijkstra(adj, n);
        Long[] mem = new Long[n+1];
        long count = dfs(1, shortest, adj, mem, n);
        return (int) count;
    }

    private long dfs(int i, int[] shortest, Map<Integer, List<int[]>> adj, Long[] mem, int n) {
        if(i == n) return 1;
        if(mem[i] != null) return mem[i];
        long res = 0;
        long MOD = (long) (1e9 + 7);
        for(int[] nei: adj.get(i)) {
            int j = nei[0];
            if(shortest[i] > shortest[j]) {
                res += dfs(j, shortest, adj, mem, n) % MOD;
            }
        }
        return mem[i] = res % MOD;
    }

    private int[] dijkstra(Map<Integer, List<int[]>> adj, int n) {
        int[] distance = new int[n+1];
        for(int i = 1; i < n; ++i)
            distance[i] = Integer.MAX_VALUE;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.add(new int[]{n, 0});
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int u = curr[0], d = curr[1];
            for(int[] nei: adj.get(u)) {
                int v = nei[0], alt = d + nei[1];
                if(alt < distance[v]) {
                    minHeap.add(new int[]{v, alt});
                    distance[v] = alt;
                }
            }
        }
        return distance;
    }
}
