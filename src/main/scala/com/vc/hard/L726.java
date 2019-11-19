package com.vc.hard;

import java.util.*;

class L726 {
    public String countOfAtoms(String formula) {
        TreeMap<String, Integer> map = solve(formula);
        StringBuilder str = new StringBuilder();
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() > 1) str.append(entry.getKey()).append(entry.getValue());
            else str.append(entry.getKey());
        }
        return str.toString();
    }

    int index = 0;
    private TreeMap<String, Integer> solve(String str) {
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        while(index < str.length() && str.charAt(index) != ')') {
            char ch = str.charAt(index);

            if(ch == '(') {
                index++;
                TreeMap<String, Integer> subMap = solve(str);
                for(String key: subMap.keySet()) {
                    map.put(key, map.getOrDefault(key, 0) + subMap.get(key));
                }
            }
            else {
                String element = "";
                if(Character.isLetter(ch)) {
                    index++;
                    element += ch;
                    while(index < str.length() && Character.isLowerCase(str.charAt(index)))
                        element += str.charAt(index++);
                }
                int power = 0;
                while(index < str.length() && Character.isDigit(str.charAt(index)))
                    power = power * 10 + str.charAt(index++) - '0';

                if(power == 0) power = 1;
                map.put(element, map.getOrDefault(element, 0) + power);
                //System.out.println("Element: "+element+" Power: "+power+" Index: "+index+" Map: "+map);
            }
        }

        int power = 0;
        index++;
        while(index < str.length() && Character.isDigit(str.charAt(index)))
            power = power * 10 + str.charAt(index++) - '0';

        //System.out.println("Power After Closing: "+power+" Map: "+map);
        if(power > 0) {
            for(String key: map.keySet()) {
                map.put(key, map.get(key) * power);
            }
        }
        //System.out.println("Power After Multiplying: "+power+" Map: "+map);
        return map;
    }
}
