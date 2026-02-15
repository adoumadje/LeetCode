package com.leetcode.sliding.window.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode3318 {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length, M = 50;
        int[] answer = new int[n-k+1];
        int[] freq = new int[M+1];
        int l = 0;
        int sum = 0;
        Comparator<int[]> comparator = (a, b) -> {
            if(b[1] == a[1]) return b[0] - a[0];
            return b[1] - a[1];
        };
        for(int r = 0; r < n; ++r) {
            freq[nums[r]] += 1;
            sum += nums[r];
            if(r-l+1 < k) {
                continue;
            } else if (r-l+1 > k) {
                sum -= nums[l];
                freq[nums[l]] -= 1;
                l += 1;
            }
            PriorityQueue<int[]> q = new PriorityQueue<>(comparator);
            for(int j = 1; j <= M; ++j) {
                if(freq[j] > 0) {
                    q.add(new int[]{j, freq[j]});
                }
            }
            for(int xx = 0; !q.isEmpty() && xx < x; ++xx) {
                int[] curr = q.poll();
                answer[l] += curr[0] *  curr[1];
            }
        }
        return answer;
    }
}
