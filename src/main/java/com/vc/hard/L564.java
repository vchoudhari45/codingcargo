package com.vc.hard;

class L564 {
    public String nearestPalindromic(String n) {
        if(n.length() == 0) return "0";
        long number = Long.parseLong(n);
        String lowerPalindrome = lower(String.valueOf(number - 1));
        String higherPalindrome = higher(String.valueOf(number + 1));
        //System.out.println(lowerPalindrome+" "+higherPalindrome);
        if(number - Long.parseLong(lowerPalindrome) <= Long.parseLong(higherPalindrome) - number)
            return lowerPalindrome;
        else
            return higherPalindrome;
    }

    private String lower(String num) {
        String palindrome = makePalindrome(num);
        long number = Long.parseLong(num);
        if(Long.parseLong(palindrome) <= number) return palindrome;
        else {
            int len = num.length();
            int mid = len % 2 == 0 ? len / 2 - 1: len / 2;

            char[] arr = num.toCharArray();
            while(mid >= 0 && arr[mid] == '0') mid--;
            arr[mid] = (char)(arr[mid] - '0' - 1 + '0');
            mid++;

            while(mid < len) arr[mid++] = '9';

            StringBuilder str = new StringBuilder();
            int i = 0;
            while(i < len && arr[i] == '0') i++;
            for(;i < len; i++) str.append(arr[i]);
            return makePalindrome(str.toString());
        }
    }

    private String higher(String num) {
        String palindrome = makePalindrome(num);
        long number = Long.parseLong(num);
        if(Long.parseLong(palindrome) >= number) return palindrome;
        else {
            int len = num.length();
            int mid = len % 2 == 0 ? len / 2 - 1: len / 2;

            char[] arr = num.toCharArray();
            while(mid >= 0 && arr[mid] == '9') mid--;
            arr[mid] = (char)(arr[mid] - '0' + 1 + '0');
            mid++;

            while(mid < len) arr[mid++] = '0';

            StringBuilder str = new StringBuilder();
            int i = 0;
            while(i < len && arr[i] == '0') i++;
            for(;i < len; i++) str.append(arr[i]);
            return makePalindrome(str.toString());
        }
    }

    private String makePalindrome(String num) {
        int len = num.length();
        if(len % 2 == 0) {
            String firstHalf = num.substring(0, len / 2);
            return firstHalf + reverse(firstHalf);
        }
        else {
            String firstHalf = num.substring(0, len / 2);
            return firstHalf + num.charAt(len / 2) + reverse(firstHalf);
        }
    }

    private String reverse(String str) {
        StringBuilder s = new StringBuilder(str);
        s.reverse();
        return s.toString();
    }
}