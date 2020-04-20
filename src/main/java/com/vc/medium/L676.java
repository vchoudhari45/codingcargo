package com.vc.medium;

import java.util.*;

class MagicDictionary {

    class Node {
        HashMap<Character, Node> map = new HashMap<>();
        boolean isWord;

        @Override
        public String toString() {
            return map.toString();
        }
    }

    class Trie {

        Node root = new Node();

        public void add(String str) {
            Node current = root;
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(!current.map.containsKey(ch)) current.map.put(ch, new Node());
                current = current.map.get(ch);
            }
            current.isWord = true;
        }

        private boolean search(String str, int index, Node current, boolean changed) {
            if(index < str.length()) {
                char ch = str.charAt(index);
                if(current.map.containsKey(ch)) {
                    if(search(str, index + 1, current.map.get(ch), changed)) return true;
                }
                if(!changed) {
                    for(Map.Entry<Character, Node> entry: current.map.entrySet()) {
                        if(entry.getKey() != ch) {
                            if(search(str, index + 1, entry.getValue(), true))  return true;
                        }
                    }
                }
            }
            return changed && current.isWord && index == str.length();
        }
    }

    private Trie trie;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        this.trie = new Trie();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String str: dict) trie.add(str);
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return trie.search(word, 0, trie.root, false);
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */