package com.vc.hard;

import java.util.*;

class L425 {
    public List<List<String>> wordSquares(String[] words) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            String prefix = "";
            for(int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                prefix += ch;
                List<String> list = map.getOrDefault(prefix, new ArrayList<String>());
                list.add(word);
                map.put(prefix, list);
            }
        }
        //System.out.println(map);
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> ans = new ArrayList<String>();
        for(String s: words) {
            ans.add(s);
            searchNext(words, map, ans, res);
            ans.remove(ans.size() - 1);
        }
        return res;
    }

    private void searchNext(String[] words,
                            Map<String, List<String>> map,
                            List<String> ans,
                            List<List<String>> res) {
        if(words[0].length() == ans.size()) {
            res.add(new ArrayList<String>(ans));
        }
        else {
            String prefix = "";
            int index = ans.size();
            for(String str: ans) {
                prefix += str.charAt(index);
            }
            //System.out.println("Searching for prefix: "+prefix+" ans: "+ans);
            List<String> startingWithPrefix = map.get(prefix);
            if(startingWithPrefix != null && startingWithPrefix.size() > 0) {
                for(String eachStartingWithPrefix: startingWithPrefix) {
                    ans.add(eachStartingWithPrefix);
                    //System.out.println("Ans: "+ ans);
                    searchNext(words, map, ans, res);
                    ans.remove(ans.size() - 1);
                }
            }
            //System.out.println("After prefix: "+prefix+" ans: "+ans+" res: "+res);
        }
    }
}
