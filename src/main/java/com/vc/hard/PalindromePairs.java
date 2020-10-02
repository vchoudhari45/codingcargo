package com.vc.hard;

import java.util.*;

class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> wordIndex = new HashMap<>();
        for(int i = 0; i < words.length; i++) wordIndex.put(words[i], i);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            for(int j = 0; j <= word.length(); j++) {
                String w1 = word.substring(0, j);
                String w2 = word.substring(j);

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

    private String reverse(String str) {
        int i = 0;
        int j = str.length() - 1;
        char[] cArr = str.toCharArray();
        while(i < j) {
            char temp = cArr[i];
            cArr[i] = cArr[j];
            cArr[j] = temp;
            i++;
            j--;
        }
        return new String(cArr);
    }

    private boolean isPalindrome(String word) {
        int i = 0;
        int j = word.length() - 1;
        while(i < j) {
            if(word.charAt(i) != word.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
