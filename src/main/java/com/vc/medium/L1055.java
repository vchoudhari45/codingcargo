package com.vc.medium;

import java.util.*;

class L1055 {
    public int shortestWay(String source, String target) {
        HashMap<Character, TreeSet<Integer>> map = new HashMap<>();
        /**
             source: "abckbc"
             target: "abcbc"

             1. Pre-process source as a map of character and indexes: {a=[0], b=[1, 4], c=[2, 5], k=[3]}

             2. Then for each characters in target lookup a map

             3. if character not fond return -1

             4. if character found at multiple place, pick an index after current sourceIndex

             5. if index after source index is null then reset sourceIndex to 0 which means we are starting a new subsequence.

             6. Which means add 1 to answer

             7. Else start new character search from index + 1

         */

        //Pre-process source as a map of character and indexes: {a=[0], b=[1, 4], c=[2, 5], k=[3]}
        for(int i = 0; i < source.length(); i++) {
            char ch = source.charAt(i);
            TreeSet<Integer> indexes = map.getOrDefault(ch, new TreeSet<Integer>());
            indexes.add(i);
            map.put(ch, indexes);
        }
        //System.out.println(map);

        int sourceIndex = 0;
        int res = 0;
        //Then for each characters in target lookup a map
        for(int i = 0; i < target.length();) {
            char ch = target.charAt(i);

            //if character not fond return -1
            if(!map.containsKey(ch)) {
                return -1;
            }

            //if character found at multiple place, then
            TreeSet<Integer> indexes = map.get(ch);

            //Pick an index after current sourceIndex
            Integer index = indexes.ceiling(sourceIndex);

            //if index after sourceIndex is null
            if(index == null) {
                //then reset sourceIndex to 0 which means we are starting a new subsequence.
                sourceIndex = 0;

                //Which means add 1 to answer
                res++;
            }
            else {
                //Else start new character search from index + 1
                sourceIndex = index + 1;
                i++;
            }
        }
        return sourceIndex > 0 ? res + 1: res;
    }
}
