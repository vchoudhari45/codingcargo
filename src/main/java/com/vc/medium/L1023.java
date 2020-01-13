package com.vc.medium;

import java.util.*;

class L1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> list = new ArrayList<>();
        for(String query: queries) {
            list.add(isValid(query, pattern));
        }
        return list;
    }

    private boolean isValid(String query, String pattern) {
        int j = 0;
        for(int i = 0; i < query.length(); i++) {
            if(j < pattern.length() && pattern.charAt(j) == query.charAt(i)) j++;
            else if(query.charAt(i) >= 'A' && query.charAt(i) <= 'Z') return false;
        }
        return pattern.length() == j;
    }
}
