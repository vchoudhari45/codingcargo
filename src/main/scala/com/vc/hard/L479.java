package com.vc.hard;

class L479 {
    public int largestPalindrome(int n) {
        long lo = n > 1 ? Long.parseLong(repeat("9", n - 1)) : 0;
        long hi = Long.parseLong(repeat("9", n));
        long prevPalindrome = hi * hi + 1;
        long maxProduct = prevPalindrome;
        //System.out.println(prevPalindrome+" "+maxProduct);
        while(prevPalindrome > lo) {
            prevPalindrome = getPrevPalindrome(prevPalindrome);
            //System.out.println(prevPalindrome);
            if(prevPalindrome < maxProduct) {
                for(long factor1 = hi; factor1 > lo; factor1--) {
                    boolean isDivisible = prevPalindrome % factor1 == 0;
                    long factor2 = prevPalindrome / factor1;
                    if(factor2 > hi) break;
                    if(isDivisible && factor2 > lo && factor2 <= hi && factor1 != factor2) {
                        //System.out.println("Factor1: "+factor1+" Factor2: "+factor2);
                        return (int)(prevPalindrome % 1337L);
                    }
                }
            }
            prevPalindrome--;
        }
        return 1;
    }

    private long getPrevPalindrome(Long l) {
        String str = Long.toString(l);
        int len = str.length();

        if(l < 10) return l;

        if(l % Math.pow(10, len - 1) == 0) return --l;

        String first = "", prev =  "", firstReverse = "", prevReverse = "";

        if(len % 2 == 0) { //even length
            first = str.substring(0, len / 2);
            prev =  Long.toString(Long.parseLong(first) - 1);

            firstReverse = reverse(first);
            prevReverse = reverse(prev);
        }
        else {  //odd length
            first = str.substring(0, (len + 1)/ 2);
            prev =  Long.toString(Long.parseLong(first) - 1);

            firstReverse = reverse(first.substring(0, len / 2));
            prevReverse = reverse(prev.substring(0, len / 2));
        }

        long cand1 = Long.parseLong(first+firstReverse);
        long cand2 = Long.parseLong(prev+prevReverse);

        //System.out.println("Getting Palindrome for: "+l+" cand1: "+cand1+" cand2: "+cand2);
        return cand1 <= l ? cand1 : cand2;
    }

    private String reverse(String str) {
        char[] c = str.toCharArray();
        int i = 0;
        int j = str.length() - 1;
        while(i < j) {
            char ch = c[i];
            c[i++] = c[j];
            c[j--] = ch;
        }
        return new String(c);
    }

    private String repeat(String a, int n) {
        String str = "";
        for(int i = 0; i < n; i++) str += a;
        return str;
    }
}