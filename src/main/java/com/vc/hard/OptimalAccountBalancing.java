package com.vc.hard;

import java.util.*;

class OptimalAccountBalancing {
    public int minTransfers(int[][] transaction) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < transaction.length; i++) {
            int lender = transaction[i][0];
            int loaner = transaction[i][1];
            int money = transaction[i][2];
            map.put(lender, map.getOrDefault(lender, 0) + money);
            map.put(loaner, map.getOrDefault(loaner, 0) - money);
        }
        List<Integer> list = new ArrayList<>(map.values());
        return solve(0, list);
    }

    private int solve(int start, List<Integer> debits) {
        int res = Integer.MAX_VALUE;
        while(start < debits.size() && debits.get(start) == 0) start++;
        if(start == debits.size()) return 0;
        for(int i = start + 1; i < debits.size(); i++) {
            if(debits.get(i) * debits.get(start) < 0) {
                debits.set(i, debits.get(i) + debits.get(start));
                res = Math.min(res, solve(start + 1, debits) + 1);
                debits.set(i, debits.get(i) - debits.get(start));
            }
        }
        return res;
    }
}