package com.vc.medium;

import java.util.*;

class L1104 {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        while(label != 0){
            res.add(0, label);
            label /= 2;
        }
        for(int level = res.size() - 2; level >= 0; level -= 2){
            int maxLabel = (1 << (level + 1)) - 1;
            int minLabel = (1 << level);
            res.set(level, minLabel + maxLabel - res.get(level));
        }
        return res;
    }
}