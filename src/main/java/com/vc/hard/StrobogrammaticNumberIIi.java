package com.vc.hard;

import java.util.*;

class StrobogrammaticNumberIIi {
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

    private void solve(char[] number, HashMap<Character, Character> map,
                       int left, int right,
                       long lo, long hi) {
        if(left > right) {
            long numberLong = Long.parseLong(new String(number));
            if(numberLong >= lo && numberLong <= hi) res++;
        }
        else {
            for(Map.Entry<Character, Character> entry: map.entrySet()) {
                char leftValue = entry.getKey();
                char rightValue = entry.getValue();

                number[left] = leftValue;
                number[right] = rightValue;

                if(number.length != 1 && leftValue == '0' && left == 0) continue;

                if(left == right && (leftValue == '6' || leftValue == '9')) continue;

                solve(number, map, left + 1, right - 1, lo, hi);
            }
        }
    }
}