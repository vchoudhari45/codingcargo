package com.vc.hard;

import java.util.*;

class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        solve("", num, 0, 0, target, 0, res);
        return res;
    }

    private void solve(String expr, String num, int index, long current, long target, long prev, List<String> res) {
        if(current == target && index == num.length()) res.add(expr);
        else {
            for(int i = index; i < num.length(); i++) {
                String digitStr = num.substring(index, i + 1);
                if(digitStr.startsWith("0") && digitStr.length() > 1) break;
                long digit = Long.parseLong(digitStr);
                if(expr.equals("")) solve(digitStr, num, i + 1, digit, target, digit, res);
                else {
                    solve(expr + "+" + digit, num, i + 1, current + digit, target, digit, res);
                    solve(expr + "-" + digit, num, i + 1, current - digit, target, -digit, res);
                    solve(expr + "*" + digit, num, i + 1, current - prev + prev * digit, target, prev * digit, res);
                }
            }
        }
    }
}