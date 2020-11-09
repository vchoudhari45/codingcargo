package com.vc.hard;

import java.util.*;

class KEmptySlots {
    public int kEmptySlots(int[] bulbs, int k) {
        TreeSet<Integer> bulbSet = new TreeSet<>();
        for(int day = 0; day < bulbs.length; day++) {
            int bulbPosition = bulbs[day];
            Integer prevBulbPosition = bulbSet.lower(bulbPosition);
            Integer nextBulbPosition = bulbSet.higher(bulbPosition);
            if((prevBulbPosition != null && bulbPosition - prevBulbPosition - 1 == k) ||
                    (nextBulbPosition != null && nextBulbPosition - bulbPosition - 1 == k)) {
                return day + 1;
            }
            bulbSet.add(bulbPosition);
        }
        return -1;
    }
}