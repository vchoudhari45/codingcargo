package com.vc.hard;

class L458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int times = minutesToTest / minutesToDie + 1;
        int pig = 0;
        while(Math.pow(times, pig) < buckets) {
            pig++;
        }
        return pig;
    }
}
