package com.vc.hard;

import java.util.*;

class L828 {
    public int uniqueLetterString(String S) {
        /**
             Consider how many substrings have a specific "A".
             For example, let's say S only has three "A"'s, at S[10], S[14] & S[20]
             and we want to know the number of substrings that contain S[14].
             The answer is that there are 4 choices for the left boundary of the substring (11, 12, 13, 14),
             and 6 choices for the right boundary (14, 15, 16, 17, 18, 19).
             So in total, there are 24 substrings that have S[14] as their unique "A".
         */
        int MOD = (int) 1e9 + 7;
        HashMap<Character, List<Integer>> indexMap = new HashMap<>();
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            List<Integer> list = indexMap.getOrDefault(ch, new ArrayList<>());
            list.add(i);
            indexMap.put(ch, list);
        }
        //System.out.println(indexMap);

        long res = 0;
        for(List<Integer> indexes: indexMap.values()) {
            //System.out.println(indexes);
            for(int i = 0; i < indexes.size(); i++) {
                long prev = i - 1 >= 0 ? indexes.get(i - 1) : -1;
                long next = i + 1 < indexes.size() ? indexes.get(i + 1) : S.length();

                long leftChoices = indexes.get(i) - prev;
                long rightChoices = next - indexes.get(i);

                res += leftChoices * rightChoices;
                //System.out.println(prev+" "+indexes.get(i)+" "+next+" "+leftChoices+" "+rightChoices);
            }
        }
        //System.out.println(res);
        return (int) res % MOD;
    }
}