package com.vc.hard;

import java.util.*;

class L857 {
    static class Entry implements Comparable<Entry> {
        double wageToQuality = 0d;
        int quality = 0;

        Entry(double wageToQuality, int quality) {
            this.wageToQuality = wageToQuality;
            this.quality = quality;
        }

        @Override
        public int compareTo(Entry e) {
            return Double.compare(wageToQuality, e.wageToQuality);
        }

        @Override
        public String toString() {
            return wageToQuality+" "+quality;
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        PriorityQueue<Entry> minWage = new PriorityQueue<>();

        for(int i = 0; i < quality.length; i++) {
            double ratio = (double)wage[i] / quality[i];
            minWage.offer(new Entry(ratio, quality[i]));
        }

        double min = Integer.MAX_VALUE;
        double totalQuality = 0;
        PriorityQueue<Integer> maxQuality = new PriorityQueue<>(Collections.reverseOrder());
        while(!minWage.isEmpty()) {
            Entry e = minWage.poll();
            //System.out.println(e);
            totalQuality += e.quality;

            maxQuality.offer(e.quality);
            if(maxQuality.size() > K) totalQuality -= maxQuality.poll();
            if(maxQuality.size() == K) min = Math.min(min, totalQuality * e.wageToQuality);
        }
        return min;
    }
}
