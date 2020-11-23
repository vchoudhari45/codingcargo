package com.vc.hard;

import java.util.Arrays;
import java.util.Comparator;

class MinimumInitialEnergyToFinishTasks {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, new Comparator<int[]>(){
            public int compare(int[] x, int[] y) {
                return Integer.compare(x[1] - x[0], y[1] - y[0]);
            }
        });

        int res = 0;
        for(int[] task: tasks) {
            res = Math.max(res + task[0], task[1]);
        }
        return res;
    }
}