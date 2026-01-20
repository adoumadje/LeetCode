package com.leetcode.dynamic_programming.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode3593 {
    List<Integer>[] adj;
    int INF = Integer.MAX_VALUE;
    int[] cost;
    int res = 0;

    public int minIncrease(int n, int[][] edges, int[] cost) {
        this.cost = cost;
        this.adj = new List[n];
        for(int[] edge: edges) {
            int u = edge[0], v = edge[1];
            if(adj[u] == null) adj[u] = new ArrayList<>();
            adj[u].add(v);
            if(adj[v] == null) adj[v] = new ArrayList<>();
            adj[v].add(u);
        }
        dfs(0, -1);
        return res;
    }

    private long dfs(int node, int parent) {
        long highest = 0;
        int hCount = 0, childCount = 0;
        for(int child: adj[node]) {
            if(child != parent) {
                long childCost = dfs(child, node);
                if(childCost > highest) {
                    hCount = 1;
                    highest = childCost;
                } else if (childCost == highest) {
                    hCount += 1;
                }
                childCount += 1;
            }
        }
        res += childCount - hCount;
        return cost[node] + highest;
    }
}
