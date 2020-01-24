package com.vc.medium;

import java.util.*;
/**
 *  Rabin Karp
 **/
class L187 {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();
        for(int i = 0; i + 10 <= s.length(); i++) {
            String str = s.substring(i, i + 10);
            if(!seen.add(str)) repeated.add(str);
        }
        return new ArrayList<>(repeated);
    }
}
