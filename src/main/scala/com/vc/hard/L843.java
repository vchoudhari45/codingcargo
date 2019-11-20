package com.vc.hard;

import java.util.*;

abstract interface Master {
    public int guess(String word);
}

class L843 {
    Random r = new Random();
    public void findSecretWord(String[] wordlist, Master master) {
        for(int i = 0, x = 0; i < 10 && x < 6; i++) {
            String guess = wordlist[r.nextInt(wordlist.length)];
            List<String> wordlist2 = new ArrayList<String>();
            x = master.guess(guess);
            for(String w: wordlist) {
                if(matches(w, guess) == x) {
                    wordlist2.add(w);
                }
            }
            wordlist = wordlist2.toArray(new String[wordlist2.size()]);
        }
    }

    private int matches(String a, String b) {
        int matches = 0;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == b.charAt(i)) {
                matches++;
            }
        }
        return matches;
    }
}
