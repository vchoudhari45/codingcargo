package com.vc.medium;

class L467 {
    public int findSubstringInWraproundString(String p) {
        if(p == null || p.length() == 0) return 0;

        int n = p.length(), maxLength = 1;
        int[] count = new int[26];

        int index = p.charAt(0) - 'a';
        count[index] = 1;

        for(int i = 1; i < p.length(); i++) {
            if(p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25)
                maxLength++;
            else
                maxLength = 1;

            index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxLength);
        }

        int sum = 0;
        for (int value : count) sum += value;
        return sum;
    }
}

