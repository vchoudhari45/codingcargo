package com.vc.medium;

class L616 {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        int end = 0;
        for(int i = 0; i < s.length(); i++) {
            for(String str: dict) {
                if(s.startsWith(str, i)) {
                    end = Math.max(end, i + str.length());
                }
            }
            bold[i] = end > i;
        }

        StringBuilder sb = new StringBuilder();
        int start = 0;
        boolean started = false;
        for(int i = 0; i < s.length(); i++) {
            if(bold[i]) {
                if(!started) {
                    started = true;
                    sb.append("<b>");
                }
            }
            else {
                if(started) {
                    started = false;
                    sb.append("</b>");
                }
            }
            sb.append(s.charAt(i));
        }
        if(started) sb.append("</b>");
        return sb.toString();
    }
}
