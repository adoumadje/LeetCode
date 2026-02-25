package com.leetcode.sliding.window.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeetCode658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length, INF = Integer.MAX_VALUE;
        int l = 0, r = n-1, m = 0;
        while (l <= r) {
            m = l + (r-l) / 2;
            if(arr[m] == x) {
                break;
            } else if (arr[m] > x) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        r = m;
        if(arr[m] > x && m > 0 && Math.abs(x-arr[m-1]) <= arr[m]-x) {
            r = m-1;
        } else if (arr[m] < x && m+1 < n && Math.abs(arr[m+1] - x) < x-arr[m]) {
            r = m+1;
        }
        l = r-1;
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < k; ++i) {
            int rd = r < n ? arr[r] - x : INF;
            int ld = l >= 0 ? x - arr[l] : INF;
            if(rd < ld) {
                answer.add(arr[r++]);
            } else if (ld != INF) {
                answer.add(arr[l--]);
            }
        }
        Collections.sort(answer);
        return answer;
    }
}
