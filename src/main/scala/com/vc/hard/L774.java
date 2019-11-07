package com.vc.hard;

import java.util.*;

class L744 {
    public double minmaxGasDist(int[] stations, int K) {
        Arrays.sort(stations);
        double lo = 0;
        double hi = stations[stations.length - 1] - stations[0];
        while(lo + 1e-6 < hi) {
            double mid = lo + (hi - lo) / 2;
            int count = 0;
            for(int i = 0; i < stations.length - 1; i++) {
                count += Math.ceil((stations[i + 1] - stations[i]) / mid) - 1;
            }
            if(count > K) lo = mid;
            else hi = mid;
        }
        return hi;
    }
}
