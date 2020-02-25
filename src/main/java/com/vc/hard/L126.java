package com.vc.hard;

import java.util.*;

class L126 {
    private HashMap<String, HashSet<String>> graph = new HashMap<>();
    private List<List<String>> res = new ArrayList<>();
    private List<String> ladder = new ArrayList<>();
    private HashSet<String> visited = new HashSet<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        wordSet.add(beginWord);

        if(!wordSet.contains(endWord)) return res;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        HashMap<String, Integer> distance = new HashMap<>();
        for(String word: wordSet) distance.put(word, -1);
        distance.put(beginWord, 0);

        while(!q.isEmpty()) {
            String word = q.poll();
            graph.put(word, new HashSet<>());
            for(int index = 0; index < word.length(); index++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    String newWord = word.substring(0, index) + ch + word.substring(index + 1);
                    if(!newWord.equals(word) && wordSet.contains(newWord)) {
                        if(distance.get(newWord) == -1 || distance.get(word) + 1 == distance.get(newWord)) {
                            graph.get(word).add(newWord);
                            distance.put(newWord, distance.get(word) + 1);
                            q.offer(newWord);
                        }
                    }
                }
            }
        }
        dfs(beginWord, endWord);
        return res;
    }

    private void dfs(String beginWord, String endWord) {
        if(visited.contains(beginWord)) return;

        if(beginWord.equals(endWord)) {
            ladder.add(endWord);
            res.add(new ArrayList<>(ladder));
            ladder.remove(ladder.size() - 1);
        }
        else {
            visited.add(beginWord);
            ladder.add(beginWord);
            for(String toWord: graph.get(beginWord)) {
                dfs(toWord, endWord);
            }
            ladder.remove(ladder.size() - 1);
            visited.remove(beginWord);
        }
    }
}