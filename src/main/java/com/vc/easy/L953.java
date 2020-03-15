package com.vc.easy;

import java.util.HashMap;

class L953 {
    public boolean isAlienSorted(String[] words, String order) {
        if(words == null || words.length == 0) return true;

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            map.put(ch, i);
        }

        int n = words.length;
        for(int i = 0; i + 1 < n; i++) {
            String current = words[i];
            String next = words[i + 1];

            int ci = 0, ni = 0;
            boolean found = false;
            while(ci < current.length() && ni < next.length()) {
                char cch = current.charAt(ci++);
                char nch = next.charAt(ni++);
                if(cch != nch) {
                    int cIndex = map.get(cch);
                    int nIndex = map.get(nch);
                    if(nIndex < cIndex) return false;
                    else {
                        found = true;
                        break;
                    }
                }
            }

            if(!found && current.length() > next.length()) return false;
        }
        return true;
    }
}
