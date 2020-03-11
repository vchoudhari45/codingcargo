package com.vc.medium;

import java.util.Stack;

class L678 {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                left.push(i);
            }
            else if(s.charAt(i) == ')') {
                if(!left.isEmpty()) left.pop();
                else if(!star.isEmpty()) star.pop();
                else return false;
            }
            else {
                star.push(i);
            }
        }

        if(left.size() > star.size()) return false;
        while(!left.isEmpty()) {
            if(left.pop() > star.pop()) return false;
        }
        return true;
    }
}
