package com.vc.hard;

class L906 {
    public int superpalindromesInRange(String L, String R) {
        long l = Long.parseLong(L);
        long r = Long.parseLong(R);
        long hi = (int)Math.ceil(Math.sqrt(r));
        long lo = (int)Math.floor(Math.sqrt(l));
        long prevPalindrome = hi + 1;
        int res = 0;
        //System.out.println("lo: "+lo+" hi: "+hi+" prevPalindrome: "+prevPalindrome);
        while(prevPalindrome >= lo) {
            prevPalindrome = getPrevPalindrome(prevPalindrome);
            long square = prevPalindrome * prevPalindrome;
            //System.out.println(prevPalindrome+" "+square+" "+l+" "+r);
            if(square >= l && square <= r && isPalindrome(square)) {
                //System.out.println(prevPalindrome);
                res++;
            }
            prevPalindrome--;
        }
        return res;
    }

    private long getPrevPalindrome(long p) {
        if(p < 10) return p;
        else {
            String str = Long.toString(p);
            int len = str.length();

            if(p % Math.pow(10, len - 1) == 0) return --p;
            else {
                long cand1 = 0;
                long cand2 = 0;
                if(len % 2 == 0) { //Length is even 1234
                    String first = str.substring(0, len / 2);
                    String prev = Long.toString(Long.parseLong(first) - 1);

                    String firstReverse = reverse(first);
                    String prevReverse = reverse(prev);

                    cand1 = Long.parseLong(first + firstReverse);
                    cand2 = Long.parseLong(prev + prevReverse);
                }
                else { // length is odd 123
                    String first = str.substring(0, (len + 1) / 2);
                    String prev = Long.toString(Long.parseLong(first) - 1);

                    String firstReverse = reverse(first.substring(0, len / 2));
                    String prevReverse = reverse(prev.substring(0, len / 2));

                    cand1 = Long.parseLong(first + firstReverse);
                    cand2 = Long.parseLong(prev + prevReverse);
                }

                return cand1 <= p ? cand1 : cand2;
            }
        }
    }


    private String reverse(String str) {
        StringBuilder s = new StringBuilder(str);
        return s.reverse().toString();
    }

    private boolean isPalindrome(long d) {
        String str = Long.toString(d);
        int i = 0;
        int j = str.length() - 1;
        while(i < j) {
            if(str.charAt(i++) != str.charAt(j--)) return false;
        }
        return true;
    }
}