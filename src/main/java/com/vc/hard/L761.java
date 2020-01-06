package com.vc.hard;

import java.util.*;

class L761 {

    /**
         Special string starts with 1 and ends with 0. Recursion on the middle part.
         Here is the process of 11011000:
         level 1 : 1 + makeLargestSpecial( 101100) + 0,
         level 2 : 10 + 1100.we need to makeLargestSpecial(10) and makeLargestSpecial(1100)
         level 3 : makeLargestSpecial(10) will just return 10, and makeLargestSpecial(1100) will return 1100
         go back to level 2, we need to sort 10 and 1100, it will be 1100, 10, now we swap once,
         go back to level 1, we join them together : 1 1100 10 0, end .
     */
    
    public String makeLargestSpecial(String S) {
        List<String> list = new ArrayList<>();

        int count = 0;
        int start = 0;
        for(int end = 0; end < S.length(); end++) {
            if(S.charAt(end) == '1') count++;
            else count--;
            if(count == 0) {
                list.add('1' + makeLargestSpecial(S.substring(start + 1, end)) + '0');
                start = end + 1;
            }
        }

        Collections.sort(list, new Comparator<String>(){
            public int compare(String s1, String s2) {
                return s2.compareTo(s1);
            }
        });

        StringBuilder s = new StringBuilder();
        for(String str: list) {
            s.append(str);
        }
        return s.toString();
    }
}
