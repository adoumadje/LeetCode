package com.leetcode.sliding.window.easy;

public class LeetCode1763 {
    char[] sa;
    char a = 'a';
    int Aa = a - 'A';
    String empty = "";

    public String longestNiceSubstring(String s) {
        this.sa = s.toCharArray();
        return divide(0, s.length()-1);
    }

    private String divide(int start, int end) {
        if(start >= end) return empty;
        boolean[] ascii = new boolean[128];
        for(int i = start; i <= end; ++i) {
            ascii[sa[i]] = true;
        }
        for(int i = start; i <= end; ++i) {
            int index = sa[i];
            int alter = index >= a ? index - Aa : index + Aa;
            if(ascii[index] && ascii[alter]) continue;
            int j = i+1;
            while (j <= end) {
                index = sa[j];
                alter = index >= a ? index - Aa : index + Aa;
                if(!(ascii[index] && ascii[alter])) {
                    j += 1;
                } else {
                    break;
                }
            }
            String left = divide(start, i-1);
            String right = divide(j, end);
            return left.length() >= right.length() ? left : right;
        }
        return new String(sa, start, end-start+1);
    }
}
