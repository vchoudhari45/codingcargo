package com.vc.medium;

class L809 {
    public int expressiveWords(String s, String[] words) {
        int res = 0;
        for(String word: words) {
            int i = 0;
            int j = 0;
            if(isStretchy(word, s)) res++;
        }
        return res;
    }

    private boolean isStretchy(String word, String s) {
        int i = 0;
        int j = 0;
        while(i < s.length() && j < word.length()) {
            if(word.charAt(j) == s.charAt(i)) {
                int len1 = getRepeated(s, i);
                int len2 = getRepeated(word, j);
                if(len1 < 3 && len1 != len2 || len1 >= 3 && len1 < len2) {
                    return false;
                }
                i += len1;
                j += len2;
            }
            else return false;
        }
        return i == s.length() && j == word.length();
    }

    private int getRepeated(String s, int index) {
        char ch = s.charAt(index);
        int oldIndex = index;
        while(index < s.length() && s.charAt(index) == ch) index++;
        return index - oldIndex;
    }
}
