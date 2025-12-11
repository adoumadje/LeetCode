package com.leetcode.dynamic_programming.medium.leetcode2998;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LeetCode2998BFS {
    public int minimumOperationsToMakeEqual(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(new int[]{x, 0});
        visited.add(x);
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int pt = curr[0], op = curr[1];

            if(pt == y) return op;

            if(pt % 11 == 0) {
                int eleven = pt / 11;
                if(!visited.contains(eleven)) {
                    visited.add(eleven);
                    q.add(new int[]{eleven, op+1});
                }
            }

            if(pt % 5 == 0) {
                int five = pt / 5;
                if(!visited.contains(five)) {
                    visited.add(five);
                    q.add(new int[]{five, op+1});
                }
            }

            if(!visited.contains(pt+1)) {
                visited.add(pt+1);
                q.add(new int[]{pt+1, op+1});
            }

            if(!visited.contains(pt-1)) {
                visited.add(pt-1);
                q.add(new int[]{pt-1, op+1});
            }
        }
        return -1;
    }
}
