package com.vc.hard;

class L214 {
    public String shortestPalindrome(String s) {
        String sNew = s + "#" + reverse(s);

        int n = sNew.length();
        int start = 0;
        int end = 1;
        int[] arr = new int[n];
        while(end < n) {
            if(sNew.charAt(end) == sNew.charAt(start)) {
                arr[end] = start + 1;
                start++;
                end++;
            }
            else {
                if(start == 0) {
                    arr[end] = 0;
                    end++;
                }
                else {
                    start = arr[start - 1];
                }
            }
        }
        // System.out.println(sNew);
        // for(int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i]);
        // }
        return reverse(s.substring(arr[n - 1])) + s;
    }

    private String reverse(String s) {
        StringBuilder str = new StringBuilder(s);
        return str.reverse().toString();
    }
}
