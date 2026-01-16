package com.leetcode.dynamic_programming.medium;

public class LeetCode3503 {
    public int longestPalindrome(String s, String t) {
        char[] sa = s.toCharArray();
        int ns = sa.length;
        char[] ta = t.toCharArray();
        int nt = ta.length;
        int res = 0;
        for(int i = 0; i < nt; ++i) {
            res = Math.max(res, palindrome(ta, i));
        }
        for(int i = 0; i < ns; ++i) {
            res = Math.max(res, palindrome(sa, i));
            for(int ii = 0; ii <= i; ++ii) {
                for(int j = 0; j < nt; ++j) {
                    for(int jj = 0; jj <= j; ++jj) {
                        String merged = s.substring(ii, i+1)
                                + t.substring(jj, j+1);
                        res = Math.max(res, palindrome(merged.toCharArray()));
                    }
                }
            }
        }
        return res;
    }

    private int palindrome(char[] arr, int i) {
        int n = arr.length;
        int res, curr = 0;
        int left = i, right = i+1;
        while (left >= 0 && right < n && arr[left--] == arr[right++])
            curr += 2;
        res = curr;
        curr = 1;
        left = i-1;
        right = i+1;
        while (left >= 0 && right < n && arr[left--] == arr[right++])
            curr += 2;
        res = Math.max(res, curr);
        return res;
    }

    private int palindrome(char[] arr) {
        int left = 0, right = arr.length-1;
        while (left <= right && arr[left] == arr[right]){
            left++;
            right--;
        }
        return left > right ? arr.length : 0;
    }
}
