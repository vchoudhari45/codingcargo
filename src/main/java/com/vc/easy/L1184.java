package com.vc.easy;

class L1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        int total = 0, res = 0;
        for(int i = 0; i < distance.length; i++) {
            if(i >= start && i < destination) {
                res += distance[i];
            }
            total += distance[i];
        }
        return Math.min(res, total - res);
    }
}
