package com.vc.medium;

import java.util.*;

class WordDictionary {

    static class Node {
        HashMap<Character, Node> map;
        boolean isWord;

        Node() {
            map = new HashMap<>();
        }
    }

    static class Trie {
        Node root = new Node();

        public void addWord(String str) {
            Node current = root;
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(!current.map.containsKey(ch)) {
                    current.map.put(ch, new Node());
                }
                current = current.map.get(ch);
            }
            current.isWord = true;
        }

        public boolean search(String str) {
            Node current = root;
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(ch == '.') {
                    for(Map.Entry<Character, Node> entry: current.map.entrySet()) {
                        if(search(str, i + 1, entry.getValue())) return true;
                    }
                    return false;
                }
                else if(current.map.containsKey(ch)) {
                    current = current.map.get(ch);
                }
                else return false;
            }
            return current.isWord;
        }


        private boolean search(String str, int index, Node root) {
            Node current = root;
            for(int i = index; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(ch == '.') {
                    for(Map.Entry<Character, Node> entry: current.map.entrySet()) {
                        if(search(str, i + 1, entry.getValue())) return true;
                    }
                    return false;
                }
                else if(current.map.containsKey(ch)) {
                    current = current.map.get(ch);
                }
                else return false;
            }
            return current.isWord;
        }
    }

    /** Initialize your data structure here. */
    private Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.addWord(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return trie.search(word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
