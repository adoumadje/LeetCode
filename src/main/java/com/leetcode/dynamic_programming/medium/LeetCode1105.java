package com.leetcode.dynamic_programming.medium;

public class LeetCode1105 {
    Integer[] mem;
    int n, shelfWidth;
    int[][] books;
    public int minHeightShelves(int[][] books, int shelfWidth) {
        this.books = books;
        this.n = books.length;
        this.shelfWidth = shelfWidth;
        mem = new Integer[n];
        return dfs(0);
    }

    public int dfs(int i) {
        if(i >= n) return 0;
        if(mem[i] != null) return mem[i];
        mem[i] = Integer.MAX_VALUE;
        int space = shelfWidth;
        int maxH = Integer.MIN_VALUE;
        for(int j = i; j < n; ++j) {
            space -= books[j][0];
            if(space < 0) break;
            maxH = Math.max(maxH, books[j][1]);
            mem[i] = Math.min(mem[i], maxH + dfs(j+1));
        }
        return mem[i];
    }
}
