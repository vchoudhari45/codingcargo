package com.vc.hard;

import java.util.*;

class L291 {
    public boolean wordPatternMatch(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        return solve(pattern, str, 0, 0, map, set);
    }

    private boolean solve(String pattern, String str,
                          int p, int s, HashMap<Character, String> map, HashSet<String> set) {
        if(p == pattern.length() && s == str.length()) return true;
        else if(p == pattern.length() || s == str.length()) return false;

        char patternChar = pattern.charAt(p);
        if(map.containsKey(patternChar)) {
            String existingString = map.get(patternChar);

            return s + existingString.length() <= str.length() &&
                    str.substring(s, s + existingString.length()).equals(existingString) &&
                    solve(pattern, str, p + 1, s + existingString.length(), map, set);
        }

        for(int i = s; i < str.length(); i ++) {
            String substring = str.substring(s, i + 1);
            if(!set.contains(substring)) {
                set.add(substring);
                map.put(patternChar, substring);

                if(solve(pattern, str, p + 1, i + 1, map, set)) return true;

                set.remove(substring);
                map.remove(patternChar);
            }
        }
        return false;
    }
}
