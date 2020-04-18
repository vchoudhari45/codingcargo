package com.vc.easy;

class L168 {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            char ch = (char)((n - 1) % 26 + 'A');
            n = (n - 1) / 26;
            sb.insert(0, ch);
        }
        return sb.toString();
    }
}
