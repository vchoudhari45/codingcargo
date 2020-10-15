package com.vc.hard;

import java.util.*;

class IPO {
    public int findMaximizedCapital(int k, int W, int[] profits, int[] capitials) {
        PriorityQueue<int[]> capital = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] x, int[] y) {
                return Integer.compare(x[0], y[0]);
            }
        });

        PriorityQueue<int[]> profit = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] x, int [] y) {
                return Integer.compare(y[1], x[1]);
            }
        });

        for(int i = 0; i < profits.length; i++) {
            int[] combined = new int[]{capitials[i], profits[i]};
            capital.add(combined);
        }

        int totalCapital = W;
        while(k > 0) {
            while(capital.size() > 0 && capital.peek()[0] <= totalCapital) {
                profit.add(capital.poll());
            }
            if(profit.size() == 0) return totalCapital;
            totalCapital += profit.poll()[1];
            k--;
        }
        return totalCapital;
    }
}