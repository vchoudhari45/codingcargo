package com.vc.medium;

import java.util.*;

class L22 {
    private List<String> list;
    private int n = 0;

    public List<String> generateParenthesis(int n) {
        this.list = new ArrayList<>();
        this.n = n;
        helper(0, 0, "");
        return list;
    }

    private void helper(int open, int close, String str) {
        if(open == close && close == n) list.add(str);

        if(open > close)
            helper(open, close + 1, str + ")");
        if(open < n)
            helper(open + 1, close, str + "(");
    }
}