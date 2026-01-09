package com.leetcode.dynamic_programming.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode3458 {
    public boolean maxSubstringLength(String s, int k) {
        char[] sa = s.toCharArray();
        int n = sa.length;
        int M = 26;
        char a = 'a';
        /**
         *  0: start, 1: end
         */
        int[][] index = new int[2][M];
        for(int i = 0; i < M; ++i) {
            index[0][i] = -1;
            index[1][i] = -1;
        }
        for(int i = 0; i < n; ++i) {
            int alph = sa[i]-a;
            if(index[0][alph] == -1) {
                index[0][alph] = i;
            }
            index[1][alph] = i;
        }
        for(int i = 0; i < M; ++i) {
            if(index[0][i] == -1) continue;
            int left = index[0][i], right = index[1][i];
            //int rLeft = left, rRight = right;
            for(int j = left+1; j < right; ++j) {
                int alph = sa[j] - a;
                int leftx = index[0][alph], rightx = index[1][alph];
                if(leftx < left) {
                    left = leftx;
                    j = left;
                }
                right = Math.max(right,  rightx);
            }
            index[0][i] = left;
            index[1][i] = right;
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[0]));
        for(int i = 0; i < M; ++i) {
            if(index[0][i] == -1 ||
                    (index[0][i] == 0 && index[1][i] == n-1)) continue;
            minHeap.offer(new int[]{index[0][i], i, 1, 0});
        }
        int maxSubstring = 0;
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int alph = curr[1], type = curr[2], val = curr[3];
            if(type == 1) {
                minHeap.offer(new int[]{index[1][alph], alph, -1, maxSubstring + 1});
            } else {
                maxSubstring = Math.max(maxSubstring, val);
            }
        }
        return maxSubstring >= k;
    }
}
