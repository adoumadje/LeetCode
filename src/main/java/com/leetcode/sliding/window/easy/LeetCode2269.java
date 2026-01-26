package com.leetcode.sliding.window.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode2269 {
    public int divisorSubstrings(int num, int k) {
        List<Integer> arr = new ArrayList<>();
        int temp = num;
        int base = (int) Math.pow(10, k);
        while (temp > 0) {
            arr.add(temp%10);
            temp /= 10;
        }
        Collections.reverse(arr);
        int n = arr.size();
        int left = 0;
        int curr = 0;
        int count = 0;
        for(int right = 0; right < n; ++right) {
            int win = right-left+1;
            curr = curr * 10 + arr.get(right);
            if (win == k) {
                if(curr > 0 && num % curr == 0) count += 1;
            } else if (win > k){
                curr -= arr.get(left) * base;
                if(curr > 0 && num % curr == 0) count += 1;
                left += 1;
            }
        }
        return count;
    }
}
