package com.vc.medium;

class L495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0, prev = 0;
        for(int time: timeSeries) {
            if(prev >= time) {
                total += duration - (prev - time);
            }
            else total += duration;
            prev = time + duration;
        }
        return total;
    }
}
