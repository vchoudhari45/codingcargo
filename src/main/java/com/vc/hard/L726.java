package com.vc.hard;

import java.util.*;

class L726 {
    public String countOfAtoms(String formula) {
        Queue<Character> q = new LinkedList<Character>();
        for(int i = 0; i < formula.length(); i++) q.offer(formula.charAt(i));
        TreeMap<String, Integer> map = solve(q);
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            sb.append(entry.getKey());
            if(entry.getValue() > 1) sb.append(entry.getValue());
        }
        return sb.toString();
    }

    private TreeMap<String, Integer> solve(Queue<Character> q) {
        TreeMap<String, Integer> map = new TreeMap<>();

        String prefix = "";
        int num = 0;
        while(!q.isEmpty()) {
            char ch = q.poll();
            if(ch >= 'A' && ch <= 'Z') {
                if(!prefix.equals("")) map.put(prefix, map.getOrDefault(prefix, 0) + (num == 0 ? 1: num));
                prefix = "";
                num = 0;
                prefix += ch;
            }
            else if(ch >= 'a' && ch <= 'z') {
                prefix += ch;
            }
            else if(ch == '(') {
                if(!prefix.equals("")) map.put(prefix, map.getOrDefault(prefix, 0) + (num == 0 ? 1: num));
                prefix = "";
                num = 0;
                TreeMap<String, Integer> subMap = solve(q);
                int factor = 0;
                while(!q.isEmpty() && q.peek() >= '0' && q.peek() <= '9') {
                    factor = factor * 10 + q.poll() - '0';
                }
                for(Map.Entry<String, Integer> entry: subMap.entrySet()) {
                    map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0) + factor * entry.getValue());
                }
            }
            else if(ch == ')') {
                if(!prefix.equals("")) map.put(prefix, map.getOrDefault(prefix, 0) + (num == 0 ? 1: num));
                prefix = "";
                num = 0;
                return map;
            }
            else if(ch >= '0' && ch <= '9') {
                num = num * 10 + ch - '0';
            }
        }

        if(!prefix.equals("")) map.put(prefix, (num == 0 ? 1: num));
        return map;
    }
}