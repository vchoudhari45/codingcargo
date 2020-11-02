package com.vc.hard;

import java.util.*;

class MaximumVacationDays {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length;
        int k = days[0].length;

        Comparator<int[]> comparator = new Comparator<int[]>(){
            public int compare(int[] x, int[] y) {
                return Integer.compare(y[1], x[1]);
            }
        };

        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(comparator);

        heap.add(new int[]{0, 0});
        for (int week = 0; week < k; week++) {
            PriorityQueue<int[]> nextHeap = new PriorityQueue<int[]>(comparator);
            while (!heap.isEmpty() && nextHeap.size() < n) {
                int[] origin = heap.poll();
                int from = origin[0];
                int vacationDays = origin[1];
                for (int to = 0; to < n; to++) {
                    if (to == origin[0] || flights[from][to] == 1) {
                        nextHeap.add(new int[]{to, vacationDays + days[to][week]});
                    }
                }
            }
            heap = nextHeap;
        }
        return heap.remove()[1];
    }
}