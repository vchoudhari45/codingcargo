package com.vc.medium;

import java.util.*;

class L22 {
    private List<String> res;
    private int n;

    public List<String> generateParenthesis(int n) {
        this.res = new ArrayList<>();
        this.n = n;
        solve("", 0, 0);
        return res;
    }

    private void solve(String str, int open, int close) {
        if(str.length() == 2 * n) res.add(str);
        if(open < n)
            solve(str + "(", open + 1, close);
        if(close < open)
            solve(str + ")", open, close + 1);
    }
}
