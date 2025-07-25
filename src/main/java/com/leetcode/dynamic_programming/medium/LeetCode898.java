package com.leetcode.dynamic_programming.medium;

import java.util.HashSet;
import java.util.Set;

public class LeetCode898 {
    public int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        Set<Integer> res = new HashSet<>();
        Set<Integer> past = new HashSet<>();
        for(int a: arr) {
            Set<Integer> curr = new HashSet<>();
            curr.add(a);
            for(int b: past) {
                curr.add(a | b);
            }
            past = curr;
            res.addAll(past);
        }
        return res.size();
    }
}
