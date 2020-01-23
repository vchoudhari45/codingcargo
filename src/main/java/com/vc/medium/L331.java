package com.vc.medium;

class L331 {
    public boolean isValidSerialization(String preorder) {
        int stack = 0;
        int i = 0;
        String[] str = preorder.split(",");
        for(i = 0; i < str.length; i++) {
            if("#".equals(str[i])) {
                if(stack == 0) break;
                stack--;
            }
            else stack++;
        }
        return stack == 0 && i ==  str.length - 1 && "#".equals(str[i]);
    }
}
