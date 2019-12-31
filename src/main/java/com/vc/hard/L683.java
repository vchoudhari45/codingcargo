package com.vc.hard;

import java.util.*;

class L683 {
    public int kEmptySlots(int[] bulbs, int K) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int day = 0; day < bulbs.length; day++) {
            int bulbPosition = bulbs[day];
            if(set.isEmpty()) {
                set.add(bulbPosition);
            }
            else {
                Integer nextPosition = set.higher(bulbPosition);
                Integer prevPosition = set.lower(bulbPosition);
                if((nextPosition != null && nextPosition - bulbPosition - 1 == K) ||
                        (prevPosition != null && bulbPosition - prevPosition - 1 == K)) return day + 1;
                set.add(bulbPosition);
            }
        }
        return -1;
    }
}