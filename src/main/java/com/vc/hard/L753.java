package com.vc.hard;

import java.util.*;

class L753 {
    /**
     When you have all the combinations of k numbers that is where you will have a password
     which when entered will open the safe
     */
    public String crackSafe(int n, int k) {
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < n; i++) str.append("0");

        HashSet<String> visited = new HashSet<>();

        visited.add(str.toString());

        int combinations = (int) Math.pow(k, n);

        solve(str, visited, combinations, n, k);

        return str.toString();
    }

    private boolean solve(StringBuilder pwd, HashSet<String> visited,
                          int combinations, int n, int k) {
        if(visited.size() == combinations) return true;

        String oldCombination = pwd.substring(pwd.length() - n + 1);
        for(char ch = '0'; ch < k + '0'; ch++) {
            String newCombination = oldCombination + ch;
            if(!visited.contains(newCombination)) {
                visited.add(newCombination);
                pwd.append(ch);
                if(solve(pwd, visited, combinations, n, k)) {
                    return true;
                }
                pwd.setLength(pwd.length() - 1);
                visited.remove(newCombination);
            }
        }
        return false;
    }
}
