package com.vc.medium;

class L647 {
    private int count = 0;
    private String s;

    public int countSubstrings(String s) {
        this.count = 0;
        this.s = s;
        for(int i = 0; i < s.length(); i++) {
            expand(i, i);       //Odd length;
            expand(i, i + 1);  //Even length;
        }
        return count;
    }

    private void expand(int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}
