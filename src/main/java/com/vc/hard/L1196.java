package com.vc.hard;

import java.util.*;

class L1196 {
    Set<String> set = new HashSet<String>();
    StringBuilder sb = new StringBuilder();
    List<String> res = new ArrayList<String>();

    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        Collections.sort(res);
        return res;
    }

    private void dfs(String str){
        if (str.indexOf('{') == -1) {
            if (set.add(str)) res.add(str);
            return;
        }

        int i = 0, l = 0, r = 0;
        while (str.charAt(i) != '}') {
            if (str.charAt(i++) == '{')
                l = i - 1;
        }
        r = i;

        String before = str.substring(0, l);
        String after = str.substring(r + 1, str.length());
        String[] args = str.substring(l + 1, r).split(",");

        for (String s : args) {
            sb.setLength(0);
            dfs(sb.append(before).append(s).append(after).toString());
        }
    }
}
