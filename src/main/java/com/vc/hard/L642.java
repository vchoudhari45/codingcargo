package com.vc.hard;

import java.util.*;

class AutocompleteSystem {

    class Node {
        String sentence;
        int times;

        public Node(String sentence, int times) {
            this.sentence = sentence;
            this.times = times;
        }
    }

    class Trie {
        int times = 0;
        HashMap<Character, Trie> map = new HashMap<Character, Trie>();
    }
    
    Trie root = new Trie();
    public AutocompleteSystem(String[] sentences, int[] times) {
        for(int i = 0; i < times.length; i++) {
            String sentence = sentences[i];
            int time = times[i];
            insert(sentence, time);
        }
    }

    public void insert(String sentence, int time) {
        Trie current = root;
        for(int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if(!current.map.containsKey(ch)) {
                current.map.put(ch, new Trie());
            }
            current = current.map.get(ch);
        }
        current.times += time;
    }


    public List<Node> lookup(String s) {
        List<Node> list = new ArrayList<Node>();
        Trie current = root;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!current.map.containsKey(ch)) {
                return new ArrayList<Node>();
            }
            else current = current.map.get(ch);
        }
        traverse(current, s, list);
        return list;
    }

    public void traverse(Trie current, String s, List<Node> list) {
        if(current.times > 0) list.add(new Node(s, current.times));
        for(Map.Entry<Character, Trie> entry: current.map.entrySet()) {
            Character key = entry.getKey();
            Trie t = entry.getValue();
            traverse(t, s + key, list);
        }
    }

    String currentPrefix = "";
    public List<String> input(char c) {
        List<String> res = new ArrayList<String>();
        if(c == '#') {
            insert(currentPrefix, 1);
            currentPrefix = "";
        }
        else {
            currentPrefix += c;
            List<Node> list = lookup(currentPrefix);
            Collections.sort(
                    list,
                    (a, b) -> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times
            );
            for(int i = 0; i < Math.min(list.size(), 3); i++) {
                res.add(list.get(i).sentence);
            }
        }
        return res;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
