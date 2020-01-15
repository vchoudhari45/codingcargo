package com.vc.medium;

import java.util.*;

class L904 {
    public int totalFruit(int[] tree) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int start = 0;
        int end = 0;
        int max = 0;
        while(end < tree.length) {
            count.put(tree[end], count.getOrDefault(tree[end], 0) + 1);
            while(count.size() > 2) {
                if(count.get(tree[start]) > 0) {
                    count.put(tree[start], count.get(tree[start]) - 1);
                    if(count.get(tree[start]) == 0) count.remove(tree[start]);
                    start++;
                }
            }
            max = Math.max(end - start + 1, max);
            end++;
        }
        return max;
    }
}
