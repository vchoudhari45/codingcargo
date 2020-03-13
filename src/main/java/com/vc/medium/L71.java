package com.vc.medium;

import java.util.Stack;

class L71 {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) return "";

        int i = 0;
        String p = "";
        Stack<String> st = new Stack<>();
        while(i < path.length()) {
            char ch = path.charAt(i);
            if(i == path.length() - 1 || ch == '/') {
                if(ch != '/') p += path.charAt(i);

                if(p.equals("..")) {
                    if(!st.isEmpty()) st.pop();
                }
                else if(!p.equals("") && !p.equals(".")) {
                    st.push(p);
                }
                p = "";
            }
            else p += ch;
            i++;
        }

        StringBuilder str = new StringBuilder("");
        while(!st.isEmpty()) str.insert(0, "/" + st.pop());
        return str.toString().equals("") ? "/" : str.toString();
    }
}
