package com.vc.hard;

import java.util.*;

class L736 {
    public int evaluate(String expr) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        return helper(expr, map);
    }

    private int helper(String expr, HashMap<String, Integer> map) {
        if(isNumber(expr)) return Integer.parseInt(expr);
        if(isVariable(expr)) return map.get(expr);

        List<String> list = parse(expr);
        if(list.get(0).equals("add")) {
            return helper(list.get(1), map) + helper(list.get(2), map);
        }
        else if(list.get(0).equals("mult")) {
            return helper(list.get(1), map) * helper(list.get(2), map);
        }
        else {
            HashMap<String, Integer> newMap = new HashMap<String, Integer>();
            newMap.putAll(map);
            for(int i = 1; i < list.size() - 2; i += 2) {
                String variable = list.get(i);
                int value = helper(list.get(i + 1), newMap);
                newMap.put(variable, value);
            }
            return helper(list.get(list.size() - 1), newMap);
        }
    }

    private List<String> parse(String expr) {
        List<String> list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        expr = expr.substring(1, expr.length() - 1);
        int countParan = 0;
        for(char ch: expr.toCharArray()) {
            if(ch == '(') {
                sb.append(ch);
                countParan++;
            }
            else if(ch == ')') {
                sb.append(ch);
                countParan--;
            }
            else if(countParan == 0 && ch == ' ') {
                list.add(sb.toString());
                sb = new StringBuilder();
            }
            else {
                sb.append(ch);
            }
        }
        if(sb.length() > 0) list.add(sb.toString());
        //System.out.println("expr: "+expr+" list: "+list);
        return list;
    }

    private boolean isNumber(String expr) {
        char ch = expr.charAt(0);
        if(ch >= '0' && ch <= '9' || ch == '-') return true;
        else return false;
    }

    private boolean isVariable(String expr) {
        char ch = expr.charAt(0);
        if(ch >= 'a' && ch <= 'z') return true;
        else return false;
    }
}
