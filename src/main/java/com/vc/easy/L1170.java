package com.vc.easy;

import java.util.*;

class L1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wc = new int[words.length];
        for(int i = 0; i < wc.length; i++) {
            wc[i] = frequency(words[i]);
            //System.out.println("Frequency for "+words[i]+" is: "+wc[i]);
        }

        Arrays.sort(wc);
        //System.out.println("\nPrinting counts:");
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int count = frequency(queries[i]);
            res[i] = getIndex(wc, count + 1);
            //System.out.println("Frequency for "+queries[i]+" is: "+count+" res: "+res[i]);
        }
        return res;
    }

    private int getIndex(int[] wc, int count) {
        int lo = 0;
        int hi = wc.length;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(wc[mid] < count) lo = mid + 1;
            else hi = mid;
        }
        return wc.length - lo;
    }

    private int frequency(String word) {
        char[] c = new char[26];
        for(int i = 0; i < word.length(); i++) {
            c[word.charAt(i) - 'a']++;
        }
        for(int i = 0; i < c.length; i++) {
            if(c[i] > 0) return c[i];
        }
        return 0;
    }
}
