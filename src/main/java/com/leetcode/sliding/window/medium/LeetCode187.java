package com.leetcode.sliding.window.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> counterMap = new HashMap<>();
        int n = s.length();
        for(int i = 0; i+10 <= n; ++i) {
            String sub = s.substring(i, i+10);
            counterMap.compute(sub, (k, v) -> {
                if(v == null) return 1;
                if(v == 1) answer.add(sub);
                return v+1;
            });
        }
        return answer;
    }
}
