package com.vc.medium;

import java.util.*;

class L127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>();
        words.addAll(wordList);
        words.add(beginWord);

        if(!words.contains(endWord)) return 0;

        HashMap<String, Integer> distance = new HashMap<>();
        for(String word: words) distance.put(word, -1);
        distance.put(beginWord, 0);

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        while(!q.isEmpty()) {
            String word = q.poll();
            for(int i = 0; i < word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    String append = (i + 1 < word.length()) ? word.substring(i + 1) : "";
                    String newWord = word.substring(0, i) + ch + append;

                    if(words.contains(newWord) && !newWord.equals(word)) {
                        if(distance.get(newWord) == -1 || distance.get(word) + 1 == distance.get(newWord)) {
                            distance.put(newWord, distance.get(word) + 1);
                            q.offer(newWord);
                        }
                    }
                }
            }
        }
        return distance.get(endWord) == -1 ? 0 : distance.get(endWord) + 1;
    }
}
