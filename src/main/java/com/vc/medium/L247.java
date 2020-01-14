package com.vc.medium;

import java.util.*;

class L247 {
    public List<String> findStrobogrammatic(int n) {
        return solve(n, n);
    }

    private List<String> solve(int current, int n) {
        if(current == 0) return Arrays.asList("");
        if(current == 1) return Arrays.asList("0","1","8");

        List<String> sub = solve(current - 2, n);

        List<String> res = new ArrayList<>();
        for (String s : sub) {
            if (current != n) res.add("0" + s + "0");
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }
}
