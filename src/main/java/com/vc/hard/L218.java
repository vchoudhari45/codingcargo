package com.vc.hard;

import java.util.*;

class Interval218 {
    int x;
    int y;
    boolean isStart;

    Interval218(int x, int y, boolean isStart) {
        this.x = x;
        this.y = y;
        this.isStart = isStart;
    }

    @Override
    public String toString() {
        return x+" "+y+" "+(isStart ? "S": "E");
    }
}

class L218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Interval218> Interval218s = new ArrayList<>();
        for(int i = 0; i < buildings.length; i++) {
            int x1 = buildings[i][0];
            int x2 = buildings[i][1];
            int height = buildings[i][2];
            Interval218s.add(new Interval218(x1, height, true));
            Interval218s.add(new Interval218(x2, height, false));
        }
        Collections.sort(Interval218s, (a, b) -> {
            int cmp = a.x - b.x;
            if(cmp != 0) return cmp;
            else {
                if(a.isStart && !b.isStart) return -1;
                else if(!a.isStart && b.isStart) return 1;
                else if(a.isStart && b.isStart) return b.y - a.y;
                else return a.y - b.y;
            }
        });
        // for(Interval218 i: Interval218s) {
        //     System.out.println(i);
        // }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        map.put(0, 1);
        int oldMax = 0;
        for(Interval218 Interval218: Interval218s) {
            int height = Interval218.y;
            if(Interval218.isStart) {
                map.put(height, map.getOrDefault(height, 0) + 1);
                if(oldMax < map.lastKey()) {
                    oldMax = map.lastKey();
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(Interval218.x);
                    l.add(oldMax);
                    res.add(l);
                }
            }
            else {
                if(map.get(height) == 1) map.remove(height);
                else map.put(height, map.get(height) - 1);
                if(oldMax > map.lastKey()) {
                    oldMax = map.lastKey();
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(Interval218.x);
                    l.add(oldMax);
                    res.add(l);
                }
            }
        }
        return res;
    }
}
