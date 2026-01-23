package com.leetcode.dynamic_programming.medium;

public class LeetCode3628 {
    public long numOfSubsequences(String s) {
        long best = calculate(s, false);
        best = Math.max(best,  calculate("L" + s, false));
        best = Math.max(best, calculate(s + "T", false));
        best = Math.max(best, calculate(s, true));
        return best;
    }

    private long calculate(String s, boolean addC) {
        long lc = 0;
        char[] sa = s.toCharArray();
        long tc = s.chars().filter(c -> c == 'T').count();
        long best = 0;
        long count = 0;
        for(char ch: sa) {
            if(ch == 'L') {
                lc += 1;
            } else if (ch == 'C') {
                count += lc * tc;
            } else if (ch == 'T') {
                tc -= 1;
            }
            best = Math.max(best, lc * tc);
        }
        if(addC) count += best;
        return count;
    }
}
