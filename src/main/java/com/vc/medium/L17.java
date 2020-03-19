package com.vc.medium;

import java.util.*;

class L17 {

    private List<String> list;
    private String digits;
    private char[][] letters;

    public List<String> letterCombinations(String digits) {
        this.list = new ArrayList<>();
        this.digits = digits;
        if(digits == null || digits.length() == 0) return list;

        this.letters = new char[][] {
                {},                 //0
                {},                 //1
                {'a','b','c'},      //2
                {'d','e','f'},      //3
                {'g','h','i'},      //4
                {'j','k','l'},      //5
                {'m','n','o'},      //6
                {'p','q','r','s'},  //7
                {'t','u','v'},      //8
                {'w','x','y', 'z'}, //9
        };
        helper(0, new StringBuilder());
        return list;
    }

    private void helper(int index, StringBuilder sb) {
        if(index == digits.length()) {
            list.add(sb.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        for(char ch: letters[digit]) {
            sb.append(ch);
            helper(index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
