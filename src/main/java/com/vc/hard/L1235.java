package com.vc.hard;

import java.util.*;

class L1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int[][] jobs = new int[startTime.length][3];
        for(int i = 0; i < startTime.length; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        map.put(0, 0);
        for(int[] job: jobs) {
            Map.Entry<Integer, Integer> prevJob = map.floorEntry(job[0]);
            int curr = prevJob.getValue() + job[2];
            if(curr > map.lastEntry().getValue())
                map.put(job[1], curr);
        }
        return map.lastEntry().getValue();
    }
}
