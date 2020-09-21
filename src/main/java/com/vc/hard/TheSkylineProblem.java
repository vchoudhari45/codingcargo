package com.vc.hard;

import java.util.*;

class TheSkylineProblem {
    static class Interval {
        int x = 0;
        int y = 0;
        boolean isStart = false;

        Interval(int x, int y, boolean isStart) {
            this.x = x;
            this.y = y;
            this.isStart = isStart;
        }

        @Override
        public String toString() {
            return x+" "+y+" "+isStart;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        //Response
        List<List<Integer>> res = new ArrayList<>();

        //Interval list
        List<Interval> list = new ArrayList<>();

        //Convert building array input into interval
        for(int[] building: buildings) {
            int start = building[0];
            int end = building[1];
            int height = building[2];
            list.add(new Interval(start, height, true));
            list.add(new Interval(end, height, false));
        }

        //Sort Interval list
        Collections.sort(list, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                int cmp = Integer.compare(i1.x, i2.x);
                if(cmp == 0) {
                    if(i1.isStart && i2.isStart) return Integer.compare(i2.y, i1.y);
                    else if(i1.isStart) return -1;
                    else if(i1.isStart) return 1;
                    else return Integer.compare(i1.y, i2.y);
                }
                return cmp;
            }
        });

        //Iterate over sorted interval list and update maxHeight based on interval
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int prevMaxHeight = 0;
        int currentMaxHeight = 0;
        map.put(0, 1);
        for(Interval interval: list) {
            //If this is start add height of this building into the map
            if(interval.isStart) {
                map.put(interval.y, map.getOrDefault(interval.y, 0) + 1);
            }
            //Else remove height of this building from the map
            else {
                map.put(interval.y, map.getOrDefault(interval.y, 0) - 1);
                if(map.get(interval.y) == 0) map.remove(interval.y);
            }

            //See if maxHeight changes, if yes add the current interval to the result set
            currentMaxHeight = map.lastKey();
            if(currentMaxHeight != prevMaxHeight) {
                res.add(Arrays.asList(interval.x, currentMaxHeight));
                prevMaxHeight = currentMaxHeight;
            }
        }

        return res;
    }
}