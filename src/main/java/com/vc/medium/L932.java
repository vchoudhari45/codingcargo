package com.vc.medium;

import java.util.*;

class L932 {
    public int[] beautifulArray(int N) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= N; i++) list.add(i);
        List<Integer> res = solve(list);
        int[] r = new int[N];
        int index = 0;
        for(Integer i: res) r[index++] = i;
        return r;
    }

    private List<Integer> solve(List<Integer> list) {
        if(list.size() == 1) return list;
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            if(i % 2 == 0) evens.add(list.get(i));
            else odds.add(list.get(i));
        }
        List<Integer> res = solve(evens);
        res.addAll(solve(odds));
        return res;
    }
}
