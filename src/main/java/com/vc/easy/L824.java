package com.vc.easy;

import java.util.HashSet;

class L824 {
    public String toGoatLatin(String S) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        StringBuilder sb = new StringBuilder();
        String[] splits = S.split(" ");
        StringBuilder suffix = new StringBuilder("a");

        for(String split: splits) {
            char ch = split.charAt(0);

            if(vowels.contains(Character.toLowerCase(ch))) {
                sb.append(split);
                sb.append("ma");
                sb.append(suffix.toString());
            }
            else {
                sb.append(split.substring(1));
                sb.append(split.charAt(0));
                sb.append("ma");
                sb.append(suffix.toString());
            }
            sb.append(" ");
            suffix.append("a");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
