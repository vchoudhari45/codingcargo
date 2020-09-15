package com.vc.hard;

import java.util.*;

class WordLadderIi {
    private HashMap<String, HashSet<String>> graph = new HashMap<>();
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Integer> distance = new HashMap<>();
        for(String word: wordList) distance.put(word, Integer.MAX_VALUE);
        distance.put(beginWord, 0);

        if(!distance.containsKey(endWord)) return res;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        while(!q.isEmpty()) {
            String word = q.poll();
            for(int i = 0; i < word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    if(word.charAt(i) != ch) {
                        String newWord = word.substring(0, i) + ch + (i + 1 < word.length() ? word.substring(i + 1) : "");
                        if(distance.containsKey(newWord) && distance.get(newWord) >= distance.get(word) + 1) {
                            distance.put(newWord, distance.get(word) + 1);
                            HashSet<String> list = graph.getOrDefault(word, new HashSet<>());
                            list.add(newWord);
                            graph.put(word, list);
                            q.offer(newWord);
                        }
                    }
                }
            }
        }

        dfs(beginWord, endWord, new ArrayList<>());
        return res;
    }

    private void dfs(String beginWord, String endWord, List<String> ladder) {
        if(beginWord.equals(endWord)) {
            ladder.add(endWord);
            res.add(new ArrayList<>(ladder));
            ladder.remove(ladder.size() - 1);
        }
        else {
            ladder.add(beginWord);
            if(graph.containsKey(beginWord)) {
                for(String word: graph.get(beginWord)) {
                    dfs(word, endWord, ladder);
                }
            }
            ladder.remove(ladder.size() - 1);
        }
    }
}