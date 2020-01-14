package com.vc.medium;

class L792 {
    public int numMatchingSubseq(String s, String[] words) {
        int res = 0;
        for(String word: words) {
            int i = 0;
            int j = 0;
            while(i < s.length() && j < word.length()) {
                if(s.charAt(i) == word.charAt(j)) {
                    i++;
                    j++;
                }
                else i++;
            }
            if(j == word.length()) res++;
        }
        return res;
    }
}
