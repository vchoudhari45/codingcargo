package com.vc.hard;

import java.util.*;

class L126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);
        words.add(beginWord);
        if(!words.contains(endWord)) return new ArrayList<List<String>>();

        Queue<String> q = new LinkedList<String>();
        HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
        HashMap<String, Integer> dist = new HashMap<String, Integer>();
        for(String word: words) {
            dist.put(word, -1);
        }
        dist.put(beginWord, 0);

        q.offer(beginWord);
        while(!q.isEmpty()) {
            String toWord = q.poll();
            char[] toWordChar = toWord.toCharArray();
            for(int index = 0; index < toWord.length(); index++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char oldChar = toWordChar[index];
                    if(oldChar != ch) {
                        toWordChar[index] = ch;
                        String newWord = new String(toWordChar);
                        if(words.contains(newWord)
                                && (dist.get(newWord) == -1 || dist.get(newWord) >= dist.get(toWord) + 1)) {
                            dist.put(newWord, dist.get(toWord) + 1);
                            HashSet<String> set = map.getOrDefault(toWord, new HashSet<String>());
                            q.offer(newWord);
                            set.add(newWord);
                            map.put(toWord, set);
                        }
                        toWordChar[index] = oldChar;
                    }
                }
            }
        }

        // for(Map.Entry<String, HashSet<String>> entry: map.entrySet()) {
        //     System.out.println(entry.getKey()+" "+entry.getValue());
        // }
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> ans = new ArrayList<String>();
        dfs(beginWord, endWord, map, res, ans);
        return res;
    }

    private void dfs(String start, String end,
                     HashMap<String, HashSet<String>> map,
                     List<List<String>> res, List<String> ans) {
        ans.add(start);
        if(start.equals(end)) {
            List<String> ansClone = new ArrayList<>(ans);
            res.add(ansClone);
        }
        else {
            if(map.containsKey(start)) {
                for(String toWord: map.get(start)) dfs(toWord, end, map, res, ans);
            }
        }
        ans.remove(ans.size() - 1);
    }
}