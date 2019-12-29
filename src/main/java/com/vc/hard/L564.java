package com.vc.hard;

class L564 {
    public String nearestPalindromic(String str) {
        int n = str.length();
        if(n == 0) return "0";
        long num = Long.parseLong(str);
        long lower = lowerPalindrome(num - 1);
        long higher = higherPalindrome(num + 1);
        System.out.println("lower: "+lower+" higher: "+higher);
        if(higher - num >= num - lower) return lower+"";
        else return higher+"";
    }

    private long lowerPalindrome(long num) {
        String s = num + "";
        int n = s.length();
        long palindrome = makePalindrome(num);
        if(palindrome <= num) return palindrome;
        else {
            int index = n % 2 == 0 ? n / 2 - 1 : n / 2;
            char[] str = (num + "").toCharArray();
            while(index >= 0 && str[index] == '0') index--;
            char before = str[index];
            str[index] = (char)(Long.parseLong(str[index]+"") - 1 + '0');
            if(str[index] == '0') {
                index++;
                while(index < n) {
                    str[index] = '9';
                    index++;
                }
            }
            return makePalindrome(Long.parseLong(new String(str)));
        }
    }

    private long higherPalindrome(long num) {
        String s = num + "";
        int n = s.length();
        long palindrome = makePalindrome(num);
        if(palindrome >= num) return palindrome;
        else {
            int index = n % 2 == 0 ? n / 2 - 1 : n / 2;
            char[] str = (num + "").toCharArray();
            while(index >= 0 && str[index] == '9') index--;
            if(index < 0) {
                StringBuilder st = new StringBuilder();
                st.append('1');
                while(index < n) {
                    st.append('0');
                    index++;
                }
            }
            else {
                str[index] = (char)(Long.parseLong(str[index]+"") + 1 + '0');
            }
            return makePalindrome(Long.parseLong(new String(str)));
        }
    }

    private long makePalindrome(long num) {
        int n = (num + "").length();
        int index = n / 2;
        String str = num + "";

        String firstHalf = str.substring(0, index);
        if(n % 2 == 0)
            return Long.parseLong(firstHalf + reverse(firstHalf));
        else
            return Long.parseLong(firstHalf + str.charAt(index) + reverse(firstHalf));
    }

    private String reverse(String str) {
        StringBuilder s = new StringBuilder(str);
        return s.reverse().toString();
    }
}
