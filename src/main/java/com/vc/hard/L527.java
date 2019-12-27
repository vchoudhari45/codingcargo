package com.vc.hard;

import java.util.*;

class L527 {

    static class Entry {
        String str;
        int index;
        int count;

        Entry(String str, int index, int count) {
            this.str = str;
            this.index = index;
            this.count = count;
        }
    }

    public List<String> wordsAbbreviation(List<String> dict) {
        List<Entry> input = new ArrayList<>();
        for(int i = 0; i < dict.size(); i++) {
            String abbr = getAbbr(dict.get(i), 1);
            input.add(new Entry(abbr, i, 1));
        }

        for(int i = 0; i < input.size(); i++) {
            resolveConflict(dict, input, i);
        }

        List<String> res = new ArrayList<>();
        for(int i = 0; i < input.size(); i++) {
            res.add(input.get(i).str);
        }
        return res;
    }

    private void resolveConflict(List<String> dict, List<Entry> input, int from) {
        while(true) {
            HashSet<Integer> set = new HashSet<>();
            for(int i = from + 1; i < input.size(); i++) {
                if(input.get(from).str.equals(input.get(i).str)) set.add(i);
            }
            if(set.isEmpty()) return;
            set.add(from);
            for(Integer i: set) {
                String abbr = getAbbr(dict.get(i), input.get(i).count + 1);
                input.set(i, new Entry(abbr, i, input.get(i).count + 1));
            }
        }
    }

    private String getAbbr(String word, int count) {
        int n = word.length();
        if(n <= 3) return word;
        else if(count >= n) return word;
        StringBuilder str = new StringBuilder();
        str.append(word.substring(0, count));
        str.append(n - count - 1);
        str.append(word.charAt(n - 1));
        if(str.length() >= word.length()) return word;
        return str.toString();
    }
}
