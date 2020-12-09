package com.vc.hard;

import java.util.ArrayList;
import java.util.List;

class CheckIfStringIsTransformableWithSubstringSortOperations {
    public boolean isTransformable(String s, String t) {
        List<Integer>[] sourceIndex = new ArrayList[10];
        for(int i = 0; i < 10; i++) sourceIndex[i] = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            sourceIndex[digit].add(i);
        }

        int[] pos = new int[10];
        for(int i = 0; i < t.length(); i++) {
            int digit = t.charAt(i) - '0';

            //Let's say digit is '1', and if target string has more 1's than source string then return false
            if(pos[digit] >= sourceIndex[digit].size()) return false;

            /**
                 All elements smaller than 'digit' should have already appeared in target string
                 Or it should be on the right side in source string

                 For e.g.
                 Source: 879
                 Target: 897

                 Now for 9 to move to left it has to be lower than 7,
                 Because only possible move is sorting elements in a window in an ascending order
            */
            for(int smallerDigit = 0; smallerDigit < digit; smallerDigit++) {
                if(pos[smallerDigit] < sourceIndex[smallerDigit].size() &&
                        sourceIndex[smallerDigit].get(pos[smallerDigit]) <
                                sourceIndex[digit].get(pos[digit])) return false;
            }
            pos[digit]++;
        }

        return true;
    }
}