package com.leetcode.dynamic_programming.medium;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode1654 {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> forb = Arrays.stream(forbidden).boxed().collect(Collectors.toSet());
        Queue<int[]> q = new LinkedList<>();
        int mf = Arrays.stream(forbidden).max().orElse(0);
        int upper = Math.max(x, mf) + 2*b;
        boolean[][] seen = new boolean[upper][2];
        // (idx, fromBack)
        q.add(new int[]{0, 0});
        seen[0][0] = true;
        int jump = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            while (len-- > 0) {
                int[] curr = q.poll();
                if(curr[0] == x)
                    return jump;
                int nIdx;
                nIdx = curr[0] + a;
                if(nIdx < upper && !seen[nIdx][0] && !forb.contains(nIdx)) {
                    q.add(new int[]{nIdx, 0});
                    seen[nIdx][0] = true;
                }
                nIdx = curr[0] - b;
                if(curr[1] == 0 && nIdx >= 0 && !seen[nIdx][1] && !forb.contains(nIdx)) {
                    q.add(new int[]{nIdx, 1});
                    seen[nIdx][1] = true;
                }
            }
            jump++;
        }
        return -1;
    }
}
