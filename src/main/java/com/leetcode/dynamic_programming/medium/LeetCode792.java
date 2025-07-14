package com.leetcode.dynamic_programming.medium;

import java.util.LinkedList;

public class LeetCode792 {

    class Word {
        String word;
        int index;

        public Word(String word) {
            this.word = word;
            this.index = 0;
        }

        public char currentChar() {
            return word.charAt(index);
        }

        public boolean isSubsequence() {
            return index == word.length();
        }
    }

    public int numMatchingSubseq(String s, String[] words) {
        int n = s.length();
        LinkedList<Word>[] lists = new LinkedList[n];
        for(int i = 0; i < n; ++i) {
            lists[i] = new LinkedList<>();
        }
        for(String w: words) {
            for(int i = 0; i < n; ++i) {
                if(w.charAt(0) == s.charAt(i)) {
                    lists[i].add(new Word(w));
                    break;
                }
            }
        }

        int counter = 0;

        for(int i = 0; i < n; ++i) {
            LinkedList<Word> list = lists[i];
            while (!list.isEmpty()) {
                Word word = list.removeFirst();
                word.index++;
                if(word.isSubsequence()) {
                    ++counter;
                    continue;
                }
                char c = word.currentChar();
                for(int j = i+1; j < n; ++j) {
                    if(c == s.charAt(j)) {
                        lists[j].addLast(word);
                    }
                }
            }
        }
        return counter;
    }
}
