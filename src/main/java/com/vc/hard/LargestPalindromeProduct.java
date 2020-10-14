package com.vc.hard;

class LargestPalindromeProduct {
    public int largestPalindrome(int n) {
        int hi = (int) Math.pow(10, n) - 1;
        int lo = hi / 10;
        for(int left = hi; left > lo; left--) {
            StringBuilder sb = new StringBuilder(Integer.toString(left));
            long palindrome = Long.parseLong(sb.toString() + sb.reverse().toString());

            for(long cand1 = hi; cand1 > lo; cand1--) {
                long cand2 = palindrome / cand1;
                if(cand2 > cand1) break;
                if(palindrome % cand1 == 0) return (int)(palindrome % 1337L);
            }
        }
        return 9;
    }
}