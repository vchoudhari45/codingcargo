package com.vc.hard;

import java.util.*;

class WordPatternIi {
    public boolean wordPatternMatch(String pattern, String str) {
        if(pattern == null && str == null) return true;
        if(pattern == null || str == null) return false;

        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        return helper(pattern, str, 0, 0, map, set);
    }

    private boolean helper(String pattern, String str, int pi, int si,
                           HashMap<Character, String> map, HashSet<String> set) {

        if(pi == pattern.length() && si == str.length()) return true;

        else if(pi == pattern.length() || si == str.length()) return false;

        char patternChar = pattern.charAt(pi);
        if(map.containsKey(patternChar)) {
            String existingMatch = map.get(patternChar);
            int existingMatchLength = existingMatch.length();

            return si + existingMatchLength <= str.length() &&
                    existingMatch.equals(str.substring(si, si + existingMatchLength)) &&
                    helper(pattern, str, pi + 1, si + existingMatchLength, map, set);
        }

        for(int i = si; i < str.length(); i++) {
            String s = str.substring(si, i + 1);
            if(!set.contains(s)) {
                set.add(s);
                map.put(patternChar, s);

                if(helper(pattern, str, pi + 1, i + 1, map, set)) return true;

                map.remove(patternChar);
                set.remove(s);
            }
        }
        return false;
    }
}
