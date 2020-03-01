package com.vc.medium;

class L1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] cost = new int[n];
        for(int i = 0; i < s.length(); i++) {
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            cost[i] = Math.abs(chs - cht);
        }

        int res = 0, start = 0, end = 0;
        while(end < n) {
            maxCost -= cost[end++];
            while(maxCost < 0) {
                maxCost += cost[start++];
            }
            res = Math.max(res, end - start);
        }
        return res;
    }
}
