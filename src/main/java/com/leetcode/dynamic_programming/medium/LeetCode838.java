package com.leetcode.dynamic_programming.medium;

import java.util.Arrays;

public class LeetCode838 {
    class Node {
        char ch;
        int dist;

        public Node(char c, int d) {
            ch = c;
            dist = d;
        }
    }

    public String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        int n = arr.length;
        Node[] left = new Node[n];
        Node[] right = new Node[n];

        char lc = arr[0];
        int ld = 1;

        char rc = arr[n-1];
        int rd = 1;

        for(int i = 0; i < n; ++i) {
            if(i > 0) {
                left[i] = new Node(lc, ld);
                if(arr[i] != '.') {
                    lc = arr[i];
                    ld = 1;
                } else {
                    ++ld;
                }
            }
            int j = n-1-i;
            if(j < n-1) {
                right[j] = new Node(rc, rd);
                if(arr[j] != '.') {
                    rc = arr[j];
                    rd = 1;
                } else {
                    ++rd;
                }
            }
        }

        char[] out = new char[n];
        for(int i = 0; i < n; ++i) {
            if(arr[i] != '.') {
                out[i] = arr[i];
            } else {
                int l = left[i] != null && left[i].ch == 'R' ? left[i].dist : 0;
                int r = right[i] != null && right[i].ch == 'L' ? right[i].dist : 0;
                int diff = l - r;
                if(r == 0 && l > 0) {
                    out[i] = 'R';
                } else if (l == 0 && r > 0) {
                    out[i] = 'L';
                } else if (diff == 0) {
                    out[i] = arr[i];
                } else if (diff > 0) {
                    out[i] = 'L';
                } else if (diff < 0) {
                    out[i] = 'R';
                }
            }
        }

        return String.valueOf(out);
    }
}
