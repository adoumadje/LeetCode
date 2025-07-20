package com.leetcode.dynamic_programming.medium;

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
        char[] dominos = dominoes.toCharArray();
        int n = dominos.length;
        Node[] left = new Node[n];
        Node[] right = new Node[n];

        char lc = dominos[0];
        int ld = 1;

        char rc = dominos[n-1];
        char rd = 1;

        for(int i = 0; i < n; ++i) {
            int j = n-1-i;
            if(i > 0) {
                left[i] = new Node(lc, ld);
                if(dominos[i] != '.') {
                    lc = dominos[i];
                    ld = 1;
                } else {
                    ld++;
                }
            }
            if(j < n-1) {
                right[j] = new Node(rc, rd);
                if(dominos[j] != '.') {
                    rc = dominos[j];
                    rd = 1;
                } else {
                    rd++;
                }
            }
        }

        char[] out = new char[n];

        for(int i = 0; i < n; ++i) {
            if()
        }
    }
}
