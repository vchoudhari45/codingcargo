package com.vc.hard;

import java.util.*;

class NumberOfAtoms {
    public String countOfAtoms(String formula) {
        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i < formula.length(); i++) {
            char ch = formula.charAt(i);
            q.offer(ch);
        }

        StringBuilder sb = new StringBuilder();
        TreeMap<String, Integer> map = helper(q);
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            sb.append(entry.getKey());
            if(entry.getValue() > 1) sb.append(entry.getValue());
        }
        return sb.toString();
    }

    private TreeMap<String, Integer> helper(Queue<Character> q) {
        TreeMap<String, Integer> map = new TreeMap<>();

        StringBuilder prefix = new StringBuilder();
        int num = 0;
        while(!q.isEmpty()) {
            char ch = q.poll();

            if(ch >= 'A' && ch <= 'Z') {
                if(!prefix.toString().equals("")) map.put(prefix.toString(), map.getOrDefault(prefix.toString(), 0) + (num == 0 ? 1 : num));
                prefix = new StringBuilder(ch + "");
                num = 0;
            }
            else if(ch == '(') {
                TreeMap<String, Integer> subMap = helper(q);
                int factor = 0;
                while(!q.isEmpty() && q.peek() >= '0' && q.peek() <= '9') {
                    char chInternal = q.poll();
                    factor = factor * 10 + (chInternal - '0');
                }
                if(factor == 0) factor = 1;
                for(Map.Entry<String, Integer> entry: subMap.entrySet()) {
                    map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0) + (factor * entry.getValue()));
                }
            }
            else if(ch >= 'a' && ch <= 'z') prefix.append(ch);
            else if(ch == ')') break;
            else num = num * 10 + (ch - '0');
        }

        if(!prefix.toString().equals("")) map.put(prefix.toString(), map.getOrDefault(prefix.toString(), 0) + (num == 0 ? 1 : num));

        return map;
    }
}