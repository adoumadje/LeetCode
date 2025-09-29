package com.leetcode.dynamic_programming.medium.leetcode1334;

public class LeetCode1334FloydWarshall {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] floyd = new int[n][n];
        int inf = (int) 1e4 + 7;

        for(int r = 0; r < n; ++r) {
            for(int c = 0; c < n; ++c) {
                if(r != c) {
                    floyd[r][c] = inf;
                }
            }
        }

        for(int[] edge: edges) {
            int r = edge[0], c = edge[1], v = edge[2];
            floyd[r][c] = v;
            floyd[c][r] = v;
        }

        for(int k = 0; k < n; ++k) {
            for(int i = 0; i < n; ++i) {
                for(int j = 0; j < n; ++j) {
                    floyd[i][j] = Math.min(floyd[i][j], floyd[i][k] + floyd[k][j]);
                }
            }
        }

        int city = -1, count = n;

        for(int r = 0; r < n; ++r) {
            int reachable = 0;
            for(int x: floyd[r]) {
                if(x > 0 && x <= distanceThreshold)
                    ++reachable;
            }
            if(reachable <= count) {
                count = reachable;
                city = r;
            }
        }
        return city;
    }
}
