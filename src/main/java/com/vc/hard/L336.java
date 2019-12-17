package com.vc.hard;

import java.util.*;

class L336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> wordIndex = new HashMap<>();
        for(int i = 0; i< words.length; i++) {
            wordIndex.put(words[i], i);
        }
        //System.out.println(wordIndex);
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            for(int j = 0; j <= word.length(); j++) {
                String w1 = word.substring(0, j);
                String w2 = word.substring(j, word.length());

                if(isPalindrome(w1)) {
                    String w2Reverse = reverse(w2);
                    if(wordIndex.containsKey(w2Reverse)) {
                        int k = wordIndex.get(w2Reverse);
                        if(i != k) res.add(Arrays.asList(k, i));
                    }
                }

                if(isPalindrome(w2) && w2.length() != 0) {
                    String w1Reverse = reverse(w1);
                    if(wordIndex.containsKey(w1Reverse)) {
                        int k = wordIndex.get(w1Reverse);
                        if(i != k) res.add(Arrays.asList(i, k));
                    }
                }
            }
        }
        return res;
    }


    private String reverse(String str){
        StringBuilder s = new StringBuilder(str);
        return s.reverse().toString();
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
