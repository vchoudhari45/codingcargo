package com.vc.easy;

import java.util.HashSet;

class L345 {
    public String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');


        int i = 0;
        int j = s.length() - 1;
        char[] arr = s.toCharArray();
        while(i < j) {
            while(i < j && !vowels.contains(s.charAt(i))) i++;
            while(i < j && !vowels.contains(s.charAt(j))) j--;

            if(i < j) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            i++;
            j--;
        }
        return new String(arr);
    }
}