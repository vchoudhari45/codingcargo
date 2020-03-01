package com.vc.medium;

import java.util.*;

class L1177 {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        /**
             PrefixCount: abcda

             a b c d e f g h i j k l m n o p q r s t u v w x y z
             0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
             1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
             2 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
             3 1 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
             4 1 1 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
             5 2 1 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
         */
        int[][] prefixCount = new int[n + 1][26];
        prefixCount[0] = new int[26];
        for(int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            prefixCount[i + 1] = prefixCount[i].clone();
            prefixCount[i + 1][ch - 'a']++;
        }

        List<Boolean> res = new ArrayList<>();
        for(int[] query: queries) {
            int from = query[0];
            int to = query[1] + 1;
            int change = query[2];

            int characterCount = 0;
            for(int i = 0; i < 26; i++) {
                characterCount += (prefixCount[to][i] - prefixCount[from][i]) % 2;
            }

            if(characterCount % 2 != 0) characterCount--;

            //We can change characters to any lowercase characters
            if(characterCount / 2 > change) res.add(false);
            else res.add(true);
        }
        return res;
    }
}
