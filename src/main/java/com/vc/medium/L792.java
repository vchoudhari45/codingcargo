package com.vc.medium;

import java.util.*;

class L792 {
    public int numMatchingSubseq(String S, String[] words) {
        /**
             S = abcde
             [a, bb, acd, ace]

             1. [a, bb, acd, ace]
                 a -> [a, acd, ace]
                 b -> [bb]

             foreach character in string "abcde"

             2. [a, acd, ace]        count = 1
                 a ->
                 b -> [bb]
                 c -> [cd, ce]

             3. [bb]
                 a ->
                 b -> [b]
                 c -> [cd, ce]

             4. [cd, ce]
                 a ->
                 b -> [b]
                 c ->
                 d -> [d]
                 e -> [e]

             5. [d]                  count = 2
                 a ->
                 b -> [b]
                 c ->
                 d ->
                 e -> [e]

             6.  [e]                 count = 3
                 a ->
                 b -> [b]
                 c ->
                 d ->
                 e ->
         */
        int ans = 0;
        List<StringBuilder>[] waiting = new List[26];
        for (int c = 'a'; c <= 'z'; c++)
            waiting[c - 'a'] = new ArrayList();

        for (String w : words)
            waiting[w.charAt(0) - 'a'].add(new StringBuilder(w));

        for (char c : S.toCharArray()) {
            List<StringBuilder> advance = waiting[c - 'a'];

            waiting[c - 'a'] = new ArrayList();
            for (StringBuilder it : advance){
                it.deleteCharAt(0);
                if(it.length() != 0)
                    waiting[it.charAt(0) - 'a'].add(it);
                else
                    ans++;
            }
        }
        return ans;
    }
}
