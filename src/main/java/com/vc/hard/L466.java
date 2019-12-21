package com.vc.hard;

class L466 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int count1 = 0;
        int count2 = 0;
        int n = s1.length();
        int m = s2.length();
        int i = 0;
        int j = 0;
        while(count1 < n1) {
            if(s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            }
            else i++;

            if(i == n) {
                count1++;
                i = 0;
            }

            if(j == m) {
                count2++;
                j = 0;
            }
        }
        return count2 / n2;
    }
}
