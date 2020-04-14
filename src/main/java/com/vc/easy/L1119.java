package com.vc.easy;

import java.util.HashSet;

class L1119 {
    public String removeVowels(String S) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        for(int i = 0; i < S.length(); i++) {
            if(!vowel.contains(S.charAt(i))) sb.append(S.charAt(i));
        }
        return sb.toString();
    }
}