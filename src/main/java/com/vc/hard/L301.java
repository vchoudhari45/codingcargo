package com.vc.hard;

import java.util.*;

class L301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null) return res;

        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        boolean found = false;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String current = q.poll();

                if(visited.contains(current)) continue;

                visited.add(current);
                boolean isValid = isValid(current);
                if(isValid) {
                    res.add(current);
                    found = true;
                }

                if(found) continue;
                for(int index = 0; index < current.length(); index++) {
                    if(current.charAt(index) == '(' || current.charAt(index) == ')') {
                        String before = current.substring(0, index);
                        String after = index + 1 <= current.length() ? current.substring(index + 1): "";
                        String next = before + after;
                        q.offer(next);
                    }
                }
            }
        }
        return res;
    }

    private boolean isValid(String str) {
        int stack = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') stack++;
            else if(str.charAt(i) == ')') stack--;
            if(stack < 0) return false;
        }
        return stack == 0;
    }
}
