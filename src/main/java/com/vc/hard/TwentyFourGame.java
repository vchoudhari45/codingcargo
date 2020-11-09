package com.vc.hard;

import java.util.*;

class TwentyFourGame {
    boolean res = false;
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for(int num: nums) list.add((double)num);
        helper(list);
        return res;
    }

    private void helper(List<Double> list) {
        if(res) return;
        if(list.size() == 1) {
            if(Math.abs(24 - list.get(0)) < 1e-5) res = true;
        }
        else {
            for(int i = 1; i < list.size(); i++) {
                for(int j = 0; j < i; j++) {
                    double d1 = list.get(i);
                    double d2 = list.get(j);
                    List<Double> possibilities = possibilities(d1, d2);

                    list.remove(i);
                    list.remove(j);
                    for(Double d: possibilities) {
                        list.add(d);
                        helper(list);
                        list.remove(list.size() - 1);
                    }
                    list.add(j, d2);
                    list.add(i, d1);
                }
            }
        }
    }

    private List<Double> possibilities(double d1, double d2) {
        List<Double> list = new ArrayList<>();
        list.add(d1 + d2);
        list.add(d1 - d2);
        list.add(d2 - d1);
        list.add(d1 * d2);
        if(d2 != 0) list.add(d1 / d2);
        if(d1 != 0) list.add(d2 / d1);
        return list;
    }
}