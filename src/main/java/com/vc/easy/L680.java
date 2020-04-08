package com.vc.easy;

class L680 {
    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        int start = 0, end = s.length() - 1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            }
            else return false;
        }
        return true;
    }
}
