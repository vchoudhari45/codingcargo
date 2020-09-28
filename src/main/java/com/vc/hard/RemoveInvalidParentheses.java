package com.vc.hard;

import java.util.*;

class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new LinkedList<>();

        if(s == null || s.length() == 0) {
            res.add("");
            return res;
        }

        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        boolean found = false;
        while(!q.isEmpty()) {
            int n = q.size();
            for(int index = 0; index < n; index++) {
                String current = q.poll();

                if(visited.contains(current)) continue;

                visited.add(current);
                if(isValid(current)) {
                    res.add(current);
                    found = true;
                }

                //We found valid Parentheses at current level
                //So No need to remove any more Parentheses just continue
                if(found) continue;

                for(int i = 0; i < current.length(); i++) {
                    if(current.charAt(i) != '(' && current.charAt(i) != ')') continue;
                    String before = i - 1 >= 0 ? current.substring(0, i) : "";
                    String after = i + 1 < current.length() ? current.substring(i + 1) : "";

                    q.offer(before + after);
                }
            }
        }
        return res;
    }

    private boolean isValid(String current) {
        int open = 0;
        for(int i = 0; i < current.length(); i++) {
            if(current.charAt(i) == '(') open++;
            else if(current.charAt(i) == ')') {
                if(open <= 0) return false;
                open--;
            }
        }
        return open == 0;
    }
}