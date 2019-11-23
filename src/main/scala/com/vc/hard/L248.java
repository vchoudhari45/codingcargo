package com.vc.hard;

import java.util.*;

class L248 {
    int res = 0;
    public int strobogrammaticInRange(String low, String high) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        long lo = Long.parseLong(low);
        long hi = Long.parseLong(high);
        for(int i = low.length(); i <= high.length(); i++) {
            solve(new char[i], map, 0, i - 1, lo, hi);
        }
        return res;
    }

    private void solve(char[] current, HashMap<Character, Character> map,
                       int left, int right,
                       long lo, long hi) {
        if(left > right) {
            //System.out.println(new String(current));
            long cInt = Long.parseLong(new String(current));
            if(cInt >= lo && cInt <= hi) {
                //System.out.println(cInt);
                res++;
            }
        }
        else {
            for(Map.Entry<Character, Character> entry: map.entrySet()) {
                char leftValue = entry.getKey();
                char rightValue = entry.getValue();

                current[left] = leftValue;
                current[right] = rightValue;

                //don't start with 0
                if (current.length != 1 && leftValue == '0' && left == 0) continue;

                //don't put 6/9 at the middle of string.
                if (left == right && (leftValue == '6' || leftValue == '9')) continue;

                solve(current, map, left + 1, right - 1, lo, hi);
            }
        }
    }
}
