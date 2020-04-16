package com.vc.easy;

class L443 {
    public int compress(char[] chars) {
        if(chars == null || chars.length == 0) return 0;

        int index = 0, count = 0, insertIndex = 0;
        while(index < chars.length) {
            char ch = chars[index];
            count = 0;
            while(index < chars.length && chars[index] == ch) {
                index++;
                count++;
            }
            chars[insertIndex++] = ch;
            if(count > 1) {
                String countString = String.valueOf(count);
                for(int i = 0; i < countString.length(); i++)
                    chars[insertIndex++] = countString.charAt(i);
            }
        }
        return insertIndex;
    }
}
