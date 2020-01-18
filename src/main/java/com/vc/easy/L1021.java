package com.vc.easy;

class L1021 {
    public String removeOuterParentheses(String s) {
        int open = 0;
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' && open++ > 0) str.append(ch);
            else if(ch == ')' && --open > 0) str.append(ch);
        }
        return str.toString();
    }
}
