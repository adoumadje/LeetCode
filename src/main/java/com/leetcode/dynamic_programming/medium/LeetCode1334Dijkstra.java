package com.leetcode.dynamic_programming.medium;

import java.util.*;

public class LeetCode1334Dijkstra {
    Map<Integer, List<int[]>> adj = new HashMap<>();
    int threshold;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        for(int[] edge: edges) {
            adj.compute(edge[0], (k, v) -> {
                if(v == null) v = new ArrayList<>();
                v.add(new int[]{edge[1], edge[2]});
                return v;
            });
            adj.compute(edge[1], (k, v) -> {
                if(v == null) v = new ArrayList<>();
                v.add(new int[]{edge[0], edge[2]});
                return v;
            });
        }

        this.threshold = distanceThreshold;
        int city = -1, count = n;
        for(int src = 0; src < n; ++src) {
            int temp = dijkstra(src);
            if(temp <= count) {
                city = src;
                count = temp;
            }
        }
        return city;
    }

    private int dijkstra(int src) {
        Comparator<int[]> comparator = Comparator.comparingInt(a -> a[1]);
        PriorityQueue<int[]> heap = new PriorityQueue<>(comparator);
        heap.add(new int[]{src, 0});
        Set<Integer> visited = new HashSet<>();

        while (!heap.isEmpty()) {
            int[] node = heap.poll();
            int city = node[0], dist = node[1];
            if(visited.contains(city)) {
                continue;
            } else {
                visited.add(city);
            }
            for(int[] nei: adj.getOrDefault(city, new ArrayList<>())) {
                int ndist = dist + nei[1];
                if(ndist <= threshold) {
                    heap.add(new int[]{nei[0], ndist});
                }
            }
        }

        return visited.size() - 1;
    }
}
