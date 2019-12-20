package com.vc.hard;

import java.util.*;

class L411 {
    class Node {
        HashMap<Character, Node> map;
        boolean isWord;

        Node() {
            map = new HashMap<>();
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

        private boolean search(String abbr, Node current, int index, int num) {
            //System.out.println("abbr: " +abbr + " index: "+index+" num: "+num);
            if(num > 0) {
                for(Map.Entry<Character, Node> entry: current.map.entrySet()) {
                    if(search(abbr, entry.getValue(), index, num - 1)) return true;
                }
                return false;
            }
            else if(index == abbr.length()) return current.isWord;
            else {
                int oldIndex = index;
                while(index < abbr.length() && abbr.charAt(index) >= '0' && abbr.charAt(index) <= '9') {
                    num = num * 10 + abbr.charAt(index) - '0';
                    index++;
                }
                if(index != oldIndex) {
                    return search(abbr, current, index, num);
                }
                while(index < abbr.length()) {
                    char ch = abbr.charAt(index);
                    if(current.map.containsKey(ch)) return search(abbr, current.map.get(ch), index + 1, num);
                    index++;
                }
                return false;
            }
        }
    }

    public String minAbbreviation(String target, String[] dictionary) {
        Trie trie = new Trie();
        for(String str: dictionary) {
            trie.addWord(str);
        }

        List<String> list = new ArrayList<>();
        for(int i = 1; i <= target.length(); i++) {
            list.clear();
            getAbbr(target, "", 0, i, false, list);
            for(String l: list) if(!trie.search(l, trie.root, 0, 0)) return l;
            //System.out.println("target: "+target+" length: "+i);
            //System.out.println(list);
        }
        return "";
    }

    private void getAbbr(String word,
                         String abbr, int index, int requiredLength, boolean prevNum, List<String> res) {
        // System.out.println("word: "+word+" abbr: "+abbr+" index: "
        //                    +index+" requiredLength: "+requiredLength+" prevNum: "+prevNum);
        if(index >= word.length()) return;
        if(!prevNum) {
            String remaining = (word.length() - index) + "";
            res.add(abbr + remaining);
        }
        if(requiredLength == 1) {
            if(index == word.length() - 1) res.add(abbr + word.charAt(index));
        }
        else {
            getAbbr(word, abbr + word.charAt(index), index + 1, requiredLength - 1, false, res);
            if(!prevNum) {
                for(int i = index + 1; i < word.length(); i++) {
                    getAbbr(word, abbr + (i - index), i, requiredLength - 1, true, res);
                }
            }
        }
    }
}
