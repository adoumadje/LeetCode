package com.leetcode.dynamic_programming.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode2901 {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<String>[] dp = new List[n];
        dp[0] = new ArrayList<>();
        dp[0].add(words[0]);
        List<String> res = dp[0];
        for(int i = 1; i < n; ++i) {
            dp[i] = new ArrayList<>();
            dp[i].add(words[i]);
            for (int j = i-1; j >= 0; --j) {
                if(groups[i] != groups[j] && hamming(words[i], words[j]) == 1
                && dp[j].size() + 1 > dp[i].size()) {
                    List<String> list = new ArrayList<>(dp[j]);
                    list.add(words[i]);
                    dp[i] = list;
                }
            }
            if(dp[i].size() > res.size())
                res = dp[i];
        }
        return res;
    }

    private int hamming(String word1, String word2) {
        if(word1.length() != word2.length()) return -1;
        int ham = 0;
        for(int i = 0; i < word1.length(); ++i) {
            if(word1.charAt(i) != word2.charAt(i))
                ham += 1;
            if(ham > 1) return ham;
        }
        return ham;
    }
}
