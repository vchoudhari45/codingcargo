package com.vc.medium;

import java.util.*;

class L1104 {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        while(label != 0){
            res.add(0, label);
            label /= 2;
        }
        for(int i = res.size() - 2; i >= 0; i -= 2){
            int maxLabel = (1 << (i + 1)) - 1;
            int minLabel = (1 << i);
            res.set(i, minLabel + maxLabel - res.get(i));
        }
        return res;
    }
}
