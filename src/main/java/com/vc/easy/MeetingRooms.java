package com.vc.easy;

import java.util.Arrays;
import java.util.Comparator;

/*****
 *  Problem No: 252
 *  Category: Data Structures And Algorithms
 *  Tags: Sort, Microsoft, Leetcode, Easy
 *  Title: Meeting Rooms
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings. It is an easy problem that uses Array Sorting to solve the problem.
 *  Description: Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 *  Input: [[0,30],[5,10],[15,20]]
 *  Output: false
 *  Similar Question: Meeting Rooms II, Merge Intervals
 *****/

class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] x, int[] y) {
                if(x[0] > y[0]) return 1;
                else return -1;
            }
        });
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i - 1][1] > intervals[i][0]) return false;
        }
        return true;
    }
}
