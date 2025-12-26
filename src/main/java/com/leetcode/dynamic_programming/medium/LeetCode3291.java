package com.leetcode.dynamic_programming.medium;

public class LeetCode3291 {
    char a = 'a';
    TrieNode head;
    int n, INF;
    String target;
    Integer[] mem;

    public int minValidStrings(String[] words, String target) {
        this.n = target.length();
        this.INF = n+2;
        this.target = target;
        this.mem = new Integer[n];
        fillDictionary(words);
        int res = dfs(0);
        return res > n ? -1 : res;
    }

    private int dfs(int start) {
        if(start >= n) return 0;
        if(mem[start] != null) return mem[start];
        int len = longestPrefix(start);
        int res = INF;
        for(int i = start; i < start + len; ++i) {
            res = Math.min(res, 1 + dfs(i+1));
        }
        return mem[start] = res;
    }

    private int longestPrefix(int start) {
        TrieNode curr = head;
        int len = 0;
        for(int i = start; i < n; ++i) {
            int index = target.charAt(i) - a;
            if(curr.children[index] == null)
                return len;
            len += 1;
            curr = curr.children[index];
        }
        return len;
    }

    private void fillDictionary(String[] words) {
        this.head = new TrieNode();
        for(String w: words) addWord(w);
    }

    private void addWord(String w) {
        TrieNode curr = head;
        for(char ch: w.toCharArray()) {
            int index = ch - a;
            if(curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
    }

    class TrieNode {
        TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }
}
