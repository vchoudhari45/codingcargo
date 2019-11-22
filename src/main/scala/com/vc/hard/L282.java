package com.vc.hard;

import java.util.*;

class L282 {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        solve(res, 0, "", num, target, 0l, 0l);
        return res;
    }

    private void solve(List<String> res, int pos,
                       String expr, String num, int target, long current, long prev) {
        //System.out.println("pos: "+pos+" expr: "+expr+" current: "+current+" prev: "+prev);
        if(pos == num.length() && target == current) {
            res.add(expr);
        }
        else {
            for(int i = pos; i < num.length(); i++) {
                if(i != pos && num.charAt(pos) == '0') break;
                long digit = Long.parseLong(num.substring(pos, i + 1));
                if(pos == 0) {
                    solve(res, i + 1, digit+"", num, target, digit, digit);
                }
                else {
                    solve(res, i + 1, expr + "+" + digit, num, target, current + digit, digit);

                    solve(res, i + 1, expr + "-" + digit, num, target, current - digit, -digit);

                    solve(res, i + 1,
                            expr + "*" + digit, num, target, current - prev + prev * digit,
                            prev * digit);
                }
            }
        }
    }
}