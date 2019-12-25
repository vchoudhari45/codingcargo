package com.vc.hard;

import java.util.*;

class L502 {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> capital = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] x, int[] y) {
                return Integer.valueOf(x[0]).compareTo(y[0]);
            }
        });

        PriorityQueue<int[]> profit = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] x, int[] y) {
                return Integer.valueOf(y[1]).compareTo(x[1]);
            }
        });

        for(int i = 0; i < Capital.length; i++) {
            //System.out.println("Capital: "+Capital[i]+" Profit: "+Profits[i]);
            capital.offer(new int[]{Capital[i], Profits[i]});
        }

        int res = W;
        while(k > 0) {
            while(!capital.isEmpty() && capital.peek()[0] <= res) {
                //System.out.println("Capital: "+capital.peek()[0]+" Profit: "+capital.peek()[1]);
                profit.offer(capital.poll());
            }
            if(profit.isEmpty()) return res;
            res += profit.poll()[1];
            k--;
        }
        return res;
    }
}
