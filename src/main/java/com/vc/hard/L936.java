package com.vc.hard;

import java.util.Stack;

class L936 {
    public int[] movesToStamp(String stamp, String target) {
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();

        int stars = 0;
        boolean[] visited = new boolean[target.length()];
        Stack<Integer> st = new Stack<>();
        while(stars < target.length()) {
            boolean replaced = false;
            //System.out.println(new String(t));
            for(int i = 0; i < target.length() - stamp.length() + 1; i++) {
                if(!visited[i] && canReplace(t, s, i)) {
                    st.push(i);
                    visited[i] = true;
                    stars += replace(t, s, i);
                    replaced = true;
                    if(stars >= target.length()) break;
                }
            }
            if(!replaced) return new int[0];
        }

        int[] res = new int[st.size()];
        int index = 0;
        while(!st.isEmpty()) {
            res[index++] = st.pop();
        }
        return res;
    }

    private boolean canReplace(char[] t, char[] s, int index) {
        for(int i = 0; i < s.length; i++) {
            if(t[i + index] != '*' && t[i + index] != s[i]) return false;
        }
        return true;
    }

    private int replace(char[] t, char[] s, int index) {
        int count = 0;
        for(int i = 0; i < s.length; i++) {
            if(t[i + index] != '*') {
                t[i + index] = '*';
                count++;
            }
        }
        return count;
    }
}
