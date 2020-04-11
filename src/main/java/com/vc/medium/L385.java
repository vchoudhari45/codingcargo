package com.vc.medium;


import com.vc.hard.NestedInteger;

import java.util.*;

class L385 {
    public NestedInteger deserialize(String s) {
        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            q.offer(s.charAt(i));
        }
        if(q.peek() == '[') q.poll();
        return solve(q);
    }

    private NestedInteger solve(Queue<Character> q) {
        NestedInteger res = new NestedInteger();
        String num = "";
        while(!q.isEmpty()) {
            char ch = q.poll();
            if(ch == '[') {
                NestedInteger ni = solve(q);
                res.add(ni);
            }
            else if(ch == ']' || ch == ',') {
                if(!num.equals("")) {
                    int n = Integer.parseInt(num);
                    NestedInteger ni = new NestedInteger(n);
                    res.add(ni);
                }
                num = "";
                if(ch == ']') break;
            }
            else num += ch;
        }
        if(!num.equals("")) {
            res.setInteger(Integer.parseInt(num));
        }
        return res;
    }
}
