package com.vc.medium;

import java.util.*;

class L386 {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for(int i = 1; i <= 9; i++) solve(i, n);
        return list;
    }

    private void solve(int current, int n) {
        if(current > n) return;
        else list.add(current);
        for(int i = 0; i < 10; i++) solve(current * 10 + i, n);
    }
}
