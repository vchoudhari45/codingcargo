package com.vc.easy;

import java.util.*;

class L299 {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < guess.length(); i++) {
            if(guess.charAt(i) == secret.charAt(i)) bull++;
            else {
                char cs = secret.charAt(i);
                char gs = guess.charAt(i);
                if(map.containsKey(cs) && map.get(cs) > 0) cow++;
                if(map.containsKey(gs) && map.get(gs) < 0) cow++;
                map.put(cs, map.getOrDefault(cs, 0) - 1);
                map.put(gs, map.getOrDefault(gs, 0) + 1);
            }
        }
        return bull+"A"+cow+"B";
    }
}
