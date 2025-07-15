package com.leetcode.dynamic_programming.medium;

import java.util.*;

public class LeetCode792 {
    class Word {
        String word;
        int index;

        public Word(String word) {
            this.word = word;
            this.index = 0;
        }

        public int getPosition() {
            return word.charAt(index) - 'a';
        }

        public boolean isSubsequence() {
            return index == word.length();
        }
    }

    public int numMatchingSubseq(String s, String[] words) {
        int n = s.length(), alph = 26;
        LinkedList<Word>[] dp = new LinkedList[alph];

        for(int i = 0; i < alph; ++i) {
            dp[i] = new LinkedList<>();
        }

        for(String w: words) {
            Word word = new Word(w);
            dp[word.getPosition()].addLast(word);
        }

        int counter = 0;

        for(char c: s.toCharArray()) {
            int i = c - 'a';
            int size = dp[i].size();
            for(int j = 0; j < size; ++j) {
                Word word = dp[i].removeFirst();
                ++word.index;
                if(word.isSubsequence()) {
                    ++counter;
                } else {
                    dp[word.getPosition()].addLast(word);
                }
            }
        }

        return counter;
    }
}
