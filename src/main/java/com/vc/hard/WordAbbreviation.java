package com.vc.hard;

import java.util.*;

class WordAbbreviation {
    static class Node {
        HashMap<Character, Node> map;
        int wordCount = 0;

        Node() {
            map = new HashMap<>();
        }
    }

    static class IndexedWord {
        int index = 0;
        String word;

        IndexedWord(int index, String word) {
            this.index = index;
            this.word = word;
        }
    }

    public List<String> wordsAbbreviation(List<String> dict) {
        List<String> res = new ArrayList<>();

        HashMap<String, List<IndexedWord>> groups = new HashMap<>();
        for(int i = 0; i < dict.size(); i++) {
            String abbr = abbr(dict.get(i), 1);
            res.add(abbr);
            List<IndexedWord> list = groups.getOrDefault(abbr, new ArrayList<>());
            list.add(new IndexedWord(i, dict.get(i)));
            groups.put(abbr, list);
        }

        for(List<IndexedWord> group: groups.values()) {
            Node root = new Node();

            //Add all the words in a group into trie
            for(IndexedWord indexedWord: group) {
                Node current = root;
                int index = indexedWord.index;
                String word = indexedWord.word;
                for(int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if(!current.map.containsKey(ch)) {
                        current.map.put(ch, new Node());
                    }
                    current.wordCount++;
                    current = current.map.get(ch);
                }
            }

            //If there is only one word in a group
            if(group.size() == 1) continue;
            else {
                for(IndexedWord indexedWord: group) {
                    Node current = root;
                    int index = indexedWord.index;
                    String word  = indexedWord.word;
                    int i = 0;
                    for(i = 0; i < word.length(); i++) {
                        char ch = word.charAt(i);
                        if(current.wordCount == 1) break;
                        current = current.map.get(ch);
                    }
                    res.set(index, abbr(word, i));
                }
            }
        }
        return res;
    }

    private String abbr(String str, int index) {
        if(str.length() <= 3) return str;

        int n = str.length();
        String prefix = str.substring(0, index);
        char suffix = str.charAt(n - 1);

        String res = "";
        if(n - 1 - index == 0) res = prefix + suffix;
        else if(n - 1 - index == 1) res = prefix + str.charAt(index) + suffix;
        else res = prefix + (n - 1 - index) + suffix;

        return res;
    }
}