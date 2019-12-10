package com.vc.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class L535 {

    private static Map<String, String> map = new HashMap<String, String>();
    private static String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static Random random = new Random();

    private static String getRandom() {
        StringBuilder st = new StringBuilder();
        for(int i = 0; i < 6; i ++) {
            st.append(chars.charAt(random.nextInt(62)));
        }
        return st.toString();
    }

    // Encodes a URL to a shortened URL.
    synchronized public String encode(String longUrl) {
        String key = getRandom();
        while(map.containsKey(key)) {
            key = getRandom();
        }
       map.put(key, longUrl);
       return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replaceAll("http://tinyurl.com/", ""));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
