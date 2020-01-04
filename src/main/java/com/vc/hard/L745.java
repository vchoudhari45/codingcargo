package com.vc.hard;

import java.util.*;

class WordFilter {

    class Node {
        int weight = 0;
        HashMap<Character, Node> map = new HashMap<>();

        Node(int weight) {
            this.weight = weight;
        }
    }

    class Trie {
        Node root = new Node(-1);

        public void addWord(String word, int weight) {
            Node current = root;
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(!current.map.containsKey(ch)) {
                    current.map.put(ch, new Node(weight));
                }
                current = current.map.get(ch);
            }
            current.weight = weight;
        }

        public int search(String word) {
            Node current = root;
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(!current.map.containsKey(ch)) return -1;
                current = current.map.get(ch);
                //System.out.println("current: "+ch+" weight: "+current.weight);
            }
            return current.weight;
        }
    }

    private Trie trie = new Trie();

    public WordFilter(String[] words) {
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            for(int j = 0; j <= word.length(); j++) {
                String suffix = word;
                String prefix = word.substring(j);
                String addWord = prefix + "{" + suffix;
                //System.out.println("Adding: "+addWord+" weight: "+i);
                trie.addWord(addWord, i);
            }
        }
    }

    private int i = 1;
    public int f(String prefix, String suffix) {
        String str = suffix+"{"+prefix;
        if(str.equals("{")) {
            //System.out.println(i+" Searching: "+str+ " Weight: "+0);
            i++;
            return 0;
        }
        else {
            int weight = trie.search(str);
            //System.out.println(i+" Searching: "+str+ " Weight: "+weight);
            i++;
            return weight;
        }
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
