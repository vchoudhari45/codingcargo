package com.vc.medium;

import java.util.*;

public class L271 {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.size(); i++) {
            sb.append(strs.get(i).length());
            sb.append("/");
            sb.append(strs.get(i));
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        //System.out.println(s);
        List<String> list = new ArrayList<>();
        int index = 0;
        while(index < s.length()) {
            int slash = s.indexOf("/", index);
            int size = Integer.parseInt(s.substring(index, slash));
            index = slash + size + 1;
            list.add(s.substring(slash + 1, index));
        }
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
