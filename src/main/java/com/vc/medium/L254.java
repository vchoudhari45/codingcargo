package com.vc.medium;

import java.util.*;

class L254 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        solve(2, n, new ArrayList<Integer>(), res);
        return res;
    }

    private void solve(int start, int n, List<Integer> list, List<List<Integer>> res) {
        for(int i = start; i * i <= n; i++) {
            if(n % i == 0) {
                list.add(i);
                list.add(n / i);
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                solve(i, n / i, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}
