package com.vc.hard;

import java.util.*;

class Ipo {
    public int findMaximizedCapital(int k, int w, int[] profit, int[] capital) {
        PriorityQueue<Integer> profitPQ = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer x, Integer y) {
                return Integer.compare(profit[y], profit[x]);
            }
        });

        PriorityQueue<Integer> capitalPQ = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer x, Integer y) {
                return Integer.compare(capital[x], capital[y]);
            }
        });

        for(int i = 0; i < capital.length; i++) capitalPQ.offer(i);

        int initialCapital = w;
        while(k > 0) {
            while(capitalPQ.size() > 0 && capital[capitalPQ.peek()] <= initialCapital) {
                int lowestCapitalProjectIndex = capitalPQ.poll();
                profitPQ.offer(lowestCapitalProjectIndex);
            }
            if(profitPQ.isEmpty()) return initialCapital;

            initialCapital += profit[profitPQ.poll()];
            k--;
        }
        return initialCapital;
    }
}