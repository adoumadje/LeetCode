package com.leetcode.dynamic_programming.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode2925 {
    List<Integer>[] adjacency;
    int[] values;

    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = values.length;
        adjacency = new List[n];
        for(int[] edge: edges) {
            int i = edge[0], j = edge[1];
            if(adjacency[i] == null) adjacency[i] = new ArrayList<>();
            adjacency[i].add(j);
            if(adjacency[j] == null) adjacency[j] = new ArrayList<>();
            adjacency[j].add(i);
        }
        this.values = values;
        long total = 0;
        for(int v: values) total += v;
        return total - dfs(0, -1);
    }

    private long dfs(int node, int parent) {
        if(adjacency[node].size() == 1 && node != 0)
            return values[node];
        long sumOfChildren = 0;
        for(int child: adjacency[node]) {
            if(child != parent)
                sumOfChildren += dfs(child, node);
        }
        return Math.min(values[node], sumOfChildren);
    }
}
