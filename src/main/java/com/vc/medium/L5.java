package com.vc.medium;

class L5 {
    int maxLength = 0, start = 0;
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n <= 1) return s;

        for(int i = 0; i < n - 1; i++) {
            expand(s, i, i);                 //even palindrome
            expand(s, i, i + 1);        //odd palindrome
        }
        return s.substring(start, start + maxLength);
    }

    private void expand(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if(maxLength < right - left - 1) {
            maxLength = right - left - 1;
            start = left + 1;
        }
    }
}
