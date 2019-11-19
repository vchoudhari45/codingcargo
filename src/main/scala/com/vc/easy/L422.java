package com.vc.easy;

import java.util.*;

class L422 {
    public boolean validWordSquare(List<String> words) {
        for(int h = 0; h < words.size(); h++) {
            String horizontalString = words.get(h);
            String verticalString = "";
            for(int v = 0; v < words.get(h).length(); v++) {
                verticalString += words.get(v).charAt(h);
            }
            if(!horizontalString.equals(verticalString)) return false;
        }
        return true;
    }
}
