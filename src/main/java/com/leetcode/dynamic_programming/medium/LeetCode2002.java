package com.leetcode.dynamic_programming.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode2002 {
    public int maxProduct(String s) {
        List<int[]> palindromes = getPalindromes(s);
        int n = palindromes.size(), res = 0;
        for(int i = 0; i < n; ++i) {
            int[] u = palindromes.get(i);
            for(int j = i+1; j < n; ++j) {
                int[] v = palindromes.get(j);
                if((u[0] & v[0]) == 0) {
                    res = Math.max(res, u[1] * v[1]);
                }
            }
        }
        return res;
    }

    private List<int[]> getPalindromes(String s) {
        List<int[]> palin = new ArrayList<>();
        int n = s.length();
        for(int x = 1; x < (1<<n); ++x) {
            StringBuilder sb = new StringBuilder();
            for(int i = n-1; i >= 0; --i) {
                if((x & (1<<i)) != 0) {
                    sb.append(s.charAt(i));
                }
            }
            if(isPalindrome(sb.toString().toCharArray())) {
                palin.add(new int[]{x, sb.length()});
            }
        }
        return palin;
    }

    private boolean isPalindrome(char[] sa) {
        int i = 0, j = sa.length - 1;
        while (i < j) {
            if(sa[i++] != sa[j--]) return false;
        }
        return true;
    }
}
