package com.vc.hard;

class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        String sNew = s + "#" + reverse(s);

        int[] kmp = new int[sNew.length()];
        int n = sNew.length();
        int start = 0, end = 1;
        while(end < n) {
            if(sNew.charAt(start) == sNew.charAt(end)) {
                kmp[end] = start + 1;
                start++;
                end++;
            }
            else {
                if(start == 0) kmp[end++] = 0;
                else start = kmp[start - 1];
            }
        }
        return reverse(s.substring(kmp[n - 1])) + s;
    }

    private String reverse(String s) {
        int start = 0, end = s.length() - 1;
        char[] cArr = s.toCharArray();
        while(start < end) {
            char ch = s.charAt(start);
            cArr[start] = cArr[end];
            cArr[end] = ch;
            start++;
            end--;
        }
        return new String(cArr);
    }
}