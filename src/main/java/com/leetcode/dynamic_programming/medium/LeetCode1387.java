package com.leetcode.dynamic_programming.medium;

import java.util.*;

public class LeetCode1387 {
    Map<Integer, Integer> mem = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
        Comparator<int[]> comparator = (a, b) -> {
            if(a[1] == b[1]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        };
        PriorityQueue<int[]> heap = new PriorityQueue<>(comparator);

        for(int x = lo; x <= hi; ++x) {
            heap.add(new int[]{x, power(x)});
        };

        int num = -1;

        while (k-- > 0 && !heap.isEmpty()) {
            num = heap.poll()[0];
        }

        return num;
    }

    private int power(int x) {
        if(x == 1) return 0;
        if(mem.containsKey(x)) return mem.get(x);

        int res = 0;
        if(x % 2 == 0) {
            res = 1 + power(x / 2);
        } else {
            res = 1 + power(3 * x + 1);
        }

        mem.put(x, res);
        return res;
    }
}
