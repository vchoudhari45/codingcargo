package com.vc.hard;

import java.util.*;

class L68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();

        int i = 0;
        int n = words.length;
        int width = 0;
        int fitting = 0;
        int start = 0;
        int charWidth = 0;
        while(i < n) {
            String str = words[i];
            // System.out.println("Trying to fit : "+str
            //                    +" width will be: "+(width + str.length() + 1));
            if(width + str.length() <= maxWidth) {
                fitting++;
                charWidth += str.length();
                width += str.length() + 1;
                i++;
            }
            else {
                res.add(format(words, start, fitting, charWidth, maxWidth));
                charWidth = 0;
                width = 0;
                fitting = 0;
                start = i;
            }
        }
        if(charWidth > 0) res.add(format(words, start, fitting, charWidth, maxWidth));
        return res;
    }

    private String format(String[] words, int start, int fitting, int charWidth, int maxWidth) {
        int totalSpaces = maxWidth - charWidth;
        if(fitting == 1 || start + fitting == words.length) {
            StringBuilder sb = new StringBuilder();
            int end = start + fitting;
            while(start < end) {
                //System.out.println(sb.toString());
                sb.append(words[start]);
                sb.append(" ");
                start++;
            }
            sb.setLength(sb.length() - 1);
            sb.append(appendSpaces(maxWidth - sb.length()));
            return sb.toString();
        }

        int spaces = totalSpaces / (fitting - 1);
        int remaining = totalSpaces % (fitting - 1);

        // System.out.println("format start: "+start
        //                   +" fitting: "+fitting
        //                   +" charWidth: "+charWidth
        //                   +" maxWidth: "+maxWidth
        //                   +" totalSpaces: "+totalSpaces
        //                   +" spaces: "+spaces
        //                   +" remaining: "+remaining);

        StringBuilder sb = new StringBuilder();
        int end = start + fitting;
        int count = 0;
        while(start < end) {
            //System.out.println(sb.toString());
            sb.append(words[start]);
            //System.out.println("Remaining: "+remaining+" spaces: "+spaces);
            if(start < end - 1) {
                sb.append(appendSpaces(spaces));
                if(count < remaining) sb.append(" ");
            }
            count++;
            start++;
        }
        return sb.toString();
    }

    private String appendSpaces(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) sb.append(" ");
        return sb.toString();
    }
}