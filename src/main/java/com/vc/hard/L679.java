package com.vc.hard;

import java.util.*;

class L679 {
    private boolean res = false;
    private double diff = 1e-5;

    public boolean judgePoint24(int[] arr) {
        List<Double> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            list.add((double)arr[i]);
        }
        solve(list);
        return res;
    }

    private void solve(List<Double> list) {
        if(res) return;
        if(list.size() == 1) {
            if(Math.abs(24 - list.get(0)) < diff) res = true;
        }
        else {
            for(int i = 0; i < list.size(); i++) {
                for(int j = 0; j < i; j++) {
                    double p1 = list.get(i);
                    double p2 = list.get(j);
                    List<Double> possibilities = possiblities(p1, p2);

                    list.remove(i);
                    list.remove(j);
                    for(Double d: possibilities) {
                        list.add(d);
                        solve(list);
                        list.remove(list.size() - 1);
                    }
                    list.add(j, p2);
                    list.add(i, p1);
                }
            }
        }
    }

    private List<Double> possiblities(double p1, double p2) {
        List<Double> d = new ArrayList<Double>();
        d.add(p1 + p2);
        d.add(p1 - p2);
        d.add(p2 - p1);
        d.add(p1 * p2);
        if(Math.abs(p2) > 0) d.add(p1 / p2);
        if(Math.abs(p1) > 0) d.add(p2 / p1);
        return d;
    }
}
