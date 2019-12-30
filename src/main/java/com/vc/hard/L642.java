package com.vc.hard;

import java.util.*;

class AutocompleteSystem {

    static class Node {
        HashMap<Character, Node> map;
        int times = 0;

        Node(int times) {
            this.times = times;
            map = new HashMap<Character, Node>();
        }
    }

    static class Entry {
        String str;
        int times;

        Entry(String str, int times) {
            this.str = str;
            this.times = times;
        }
    }

    static class Trie {
        Node root = new Node(0);

        private void addWord(String word, int times) {
            Node current = root;
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(!current.map.containsKey(ch)) {
                    current.map.put(ch, new Node(0));
                }
                current = current.map.get(ch);
            }
            current.times += times;
        }

        private List<Entry> search(String prefix) {
            Node current = root;
            for(int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                if(current == null) return new ArrayList<Entry>();
                else if(current.map.containsKey(ch)) {
                    current = current.map.get(ch);
                }
                else {
                    return new ArrayList<Entry>();
                }
            }
            List<Entry> res = getAll(prefix, current);
            return res;
        }

        private List<Entry> getAll(String str, Node current) {
            List<Entry> res = new ArrayList<Entry>();
            if(current.times > 0) {
                res.add(new Entry(str, current.times));
            }
            for(Map.Entry<Character, Node> node: current.map.entrySet()) {
                res.addAll(getAll(str + node.getKey(), node.getValue()));
            }
            return res;
        }
    }

    Trie trie = new Trie();
    public AutocompleteSystem(String[] sentences, int[] times) {
        for(int i = 0; i < times.length; i++) {
            trie.addWord(sentences[i], times[i]);
        }
    }

    String prefix = "";
    public List<String> input(char c) {
        if(c == '#') {
            //System.out.println("Adding word: "+prefix);
            trie.addWord(prefix, 1);
            prefix = "";
            return new ArrayList<String>();
        }
        else {
            prefix += c;
            List<Entry> list = trie.search(prefix);
            return reformat(list);
        }
    }

    private List<String> reformat(List<Entry> list) {
        List<String> res = new ArrayList<String>();
        Collections.sort(list, new Comparator<Entry>(){
            public int compare(Entry n1, Entry n2) {
                int cmp = Integer.valueOf(n2.times).compareTo(n1.times);
                if(cmp == 0) return n1.str.compareTo(n2.str);
                return cmp;
            }
        });
        for(int i = 0; i < Math.min(3, list.size()); i++) res.add(list.get(i).str);
        return res;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */