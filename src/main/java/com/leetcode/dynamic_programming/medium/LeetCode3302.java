package com.leetcode.dynamic_programming.medium;

import java.util.Arrays;

public class LeetCode3302 {
    public int[] validSequence(String word1, String word2) {
        char[] wa1 = word1.toCharArray();
        char[] wa2 = word2.toCharArray();
        int n1 = wa1.length, n2 = wa2.length;
        int j = n1-1;
        int[] good = new int[n2+1];
        Arrays.fill(good, -1);
        good[n2] = n2;
        for(int i = n2-1; i >= 0; --i) {
            while(j >= 0 && wa1[j] != wa2[i]) j -= 1;
            if(j < 0) break;
            good[i] = j;
            j -= 1;
        }
        j = 0;
        int[] res = new int[n2];
        int len = 0;
        boolean used = false;
        for(int i = 0; i < n1; ++i) {
            if(j >= n2) break;
            if(wa1[i] == wa2[j]) {
                ++len;
                res[j++] = i;
            } else if (!used && good[j+1] > i) {
                ++len;
                res[j++] = i;
                used = true;
            }
        }
        return len < n2 ? new int[0] : res;
    }
}
