package com.vc.hard;

import java.util.*;

class CourseScheduleIii {
    public int scheduleCourse(int[][] courses) {
        //Sort courses by, closed on day in ascending order
        Arrays.sort(courses, new Comparator<int[]>(){
            public int compare(int[] x, int[] y) {
                return Integer.compare(x[1], y[1]);
            }
        });

        //Priority Queue which returns course with greater duration first
        PriorityQueue<Integer> durationPQ = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer x, Integer y) {
                return Integer.compare(y, x);
            }
        });

        int time = 0;
        for(int[] course: courses) {
            int duration = course[0];
            int endBefore = course[1];

            if(time + duration <= endBefore) {
                durationPQ.offer(duration);
                time += duration;
            }
            else if(!durationPQ.isEmpty() && durationPQ.peek() > duration) {
                time -= durationPQ.poll();
                time += duration;
                durationPQ.offer(duration);
            }
        }

        return durationPQ.size();
    }
}