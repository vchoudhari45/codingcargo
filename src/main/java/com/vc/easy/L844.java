package com.vc.easy;

import java.util.Stack;

class L844 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> sts = new Stack<>();
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '#') {
                if(!sts.isEmpty()) sts.pop();
            }
            else sts.push(S.charAt(i));
        }

        Stack<Character> stt = new Stack<>();
        for(int i = 0; i < T.length(); i++) {
            if(T.charAt(i) == '#') {
                if(!stt.isEmpty()) stt.pop();
            }
            else stt.push(T.charAt(i));
        }

        while(!sts.isEmpty() && !stt.isEmpty()) {
            if(sts.pop() != stt.pop()) return false;
        }

        return sts.isEmpty() && stt.isEmpty();
    }
}
