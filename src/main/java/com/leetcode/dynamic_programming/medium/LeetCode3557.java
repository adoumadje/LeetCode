package com.leetcode.dynamic_programming.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode3557 {
    public int maxSubstrings(String word) {
        char[] wa = word.toCharArray();
        int n = wa.length;
        char a = 'a';
        List<Integer>[] indexes = new List[26];
        for(int i = 0; i < n; ++i) {
            int alph = wa[i] - a;
            if(indexes[alph] == null) indexes[alph] = new ArrayList<>();
            indexes[alph].add(i);
        }
        int[] events = new int[n];
        Arrays.fill(events, -1);
        for(int i = 0; i < n; ++i) {
            int alph = wa[i] - a;
            int left = 0, right = indexes[alph].size() - 1;
            int next = -1;
            while(left <= right) {
                int mid = left + (right-left) / 2;
                if(indexes[alph].get(mid) - i >= 3) {
                    next = indexes[alph].get(mid);
                    right = mid-1;
                } else {
                    left = mid + 1;
                }
            }
            events[i] = next;
        }
        int[] best = new int[n];
        int sweep = 0;
        for(int i = 0; i < n; ++i) {
            if(events[i] != -1) {
                int next = events[i];
                best[next] = sweep + 1;
            }
            sweep = Math.max(sweep, best[i]);
        }
        return sweep;
    }
}
