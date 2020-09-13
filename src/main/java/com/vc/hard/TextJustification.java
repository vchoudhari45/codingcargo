package com.vc.hard;

import java.util.*;

class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int index = 0;
        int width = 0;
        int widthWithoutSpace = 0;
        int fitting = 0;
        int start = 0;
        List<String> res = new ArrayList<>();

        while(index < words.length) {
            if(width + words[index].length() <= maxWidth) {
                width = Math.min(maxWidth, width + words[index].length() + 1);
                widthWithoutSpace = widthWithoutSpace + words[index].length();
                fitting++;
                index++;
            }
            else {
                format(words, width, widthWithoutSpace, maxWidth, start, fitting, res);
                width = 0;
                widthWithoutSpace = 0;
                fitting = 0;
                start = index;
            }
        }
        if(fitting > 0) format(words, width, widthWithoutSpace, maxWidth, start, fitting, res);
        return res;
    }

    private void format(String[] words, int width, int widthWithoutSpace, int maxWidth,
                        int start, int fitting,
                        List<String> res) {
        //We will want last line to be left justified
        //So if it is only one word or if it is last line, just append one spaces
        //And append remainingSpaces later
        if(fitting == 1 || start + fitting == words.length) {
            StringBuilder sb = new StringBuilder();
            int index = 0;
            while(index < fitting) {
                sb.append(words[start + index]);
                if(index < fitting - 1) sb.append(" ");
                index++;
            }
            int remainingSpaces = maxWidth - (widthWithoutSpace + fitting - 1);
            for(int space = 0; space < remainingSpaces; space++) sb.append(" ");
            res.add(sb.toString());
        }
        else {
            int index = 0;
            int totalSpaces = maxWidth - widthWithoutSpace;
            int spaces = totalSpaces / (fitting - 1);
            int remainingSpaces = totalSpaces % (fitting - 1);
            StringBuilder sb = new StringBuilder();
            while(index < fitting) {
                sb.append(words[start + index]);
                if(index < fitting - 1) {
                    for(int s = 0; s < spaces; s++) sb.append(" ");
                    if(remainingSpaces-- > 0) sb.append(" ");
                }
                index++;
            }
            res.add(sb.toString());
        }
    }
}