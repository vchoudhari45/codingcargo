package com.vc.hard;

import java.util.*;

class RangeModule {

    TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

    public void addRange(int left, int right) {
        //System.out.println("Before Adding "+map);
        Integer pre = map.floorKey(left);
        Integer next = map.floorKey(right);

        if(pre != null && map.get(pre) >= left) {
            left = pre;
        }

        if(next != null && map.get(next) > right) {
            right = map.get(next);
        }
        map.put(left, right);
        map.subMap(left, false, right, true).clear();
        //System.out.println("After Adding "+map);
    }

    public boolean queryRange(int left, int right) {
        //System.out.println("Before Querying "+map);
        Integer node = map.floorKey(left);
        if(node == null) return false;
        return map.get(node) >= right;
    }

    public void removeRange(int left, int right) {
        //System.out.println("Before Removing "+map);
        Integer pre = map.floorKey(left);
        Integer next = map.floorKey(right);

        if(next != null && map.get(next) > right) {
            map.put(right, map.get(next));
        }

        if(pre != null && map.get(pre) > left) {
            map.put(pre, left);
        }
        map.subMap(left, true, right, false).clear();
        //System.out.println("After Removing "+map);
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */