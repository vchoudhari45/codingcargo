package com.vc.easy;

import java.util.HashMap;

class L246 {
    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');

        String str = "";
        for(int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            if(map.containsKey(ch)) str = map.get(ch) + str;
            else return false;
        }
        return str.equals(num);
    }
}
