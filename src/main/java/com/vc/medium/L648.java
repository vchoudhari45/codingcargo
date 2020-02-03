package com.vc.medium;

import java.util.*;

class L648 {
    static class Node {
        HashMap<Character, Node> map;
        boolean isWord;
        Node() {
            map = new HashMap<Character, Node>();
        }
    }

    class Trie {
        Node root = new Node();

        private void addWord(String word) {
            Node current = root;
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(!current.map.containsKey(ch)) current.map.put(ch, new Node());
                current = current.map.get(ch);
            }
            current.isWord = true;
        }

        private String getParent(String word) {
            Node current = root;
            String w = "";
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(current.isWord) return w;
                if(!current.map.containsKey(ch)) return null;
                current = current.map.get(ch);
                w += ch;
            }
            return null;
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();
        for(String d: dict) trie.addWord(d);

        StringBuilder sb = new StringBuilder();
        for(String s: sentence.split(" ")) {
            String parent = trie.getParent(s);
            if(parent == null) sb.append(s);
            else sb.append(parent);
            sb.append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

}
