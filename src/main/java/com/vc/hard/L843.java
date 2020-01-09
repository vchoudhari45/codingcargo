package com.vc.hard;

import java.util.*;

abstract interface Master {
    public int guess(String word);
}

class L843 {

    private Random r = new Random();

    public void findSecretWord(String[] wordlist, Master master) {
        int matchedCount = 0;
        for(int i = 0; i < 10 && matchedCount < 6; i++) {
            //System.out.println("wordlist: "+wordlist.length+" matchedCount: "+matchedCount);

            String wordGuess = wordlist[r.nextInt(wordlist.length)];
            matchedCount = master.guess(wordGuess);

            List<String> nextWordlist = new ArrayList<>();
            for(String word: wordlist) {
                if(matches(word, wordGuess) == matchedCount) nextWordlist.add(word);
            }

            wordlist = new String[nextWordlist.size()];
            for(int index = 0; index < nextWordlist.size(); index++) {
                wordlist[index] = nextWordlist.get(index);
            }
        }
        // System.out.println("Secret is in ");
        // for(String word: wordlist) {
        //     System.out.println(word);
        // }
    }

    private int matches(String a, String b) {
        int res = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) == b.charAt(i)) res++;
        }
        return res;
    }
}