package com.vc.medium;

import java.util.*;

class SnapshotArray {

    TreeMap<Integer, Integer>[] arr;
    int n = 0;
    int snapId = 0;
    public SnapshotArray(int length) {
        this.n = length;
        arr = new TreeMap[length];
    }

    public void set(int index, int val) {
        if(arr[index] == null) arr[index] = new TreeMap<Integer, Integer>();
        arr[index].put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snapId) {
        if(arr[index] == null) return 0;
        else if(arr[index].floorKey(snapId) == null) return 0;
        else return arr[index].floorEntry(snapId).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */