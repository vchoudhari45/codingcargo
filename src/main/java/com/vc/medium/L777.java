package com.vc.medium;

class L777 {
    public boolean canTransform(String start, String end) {
        int p1 = 0;
        int p2 = 0;
        if(!start.replaceAll("X", "").equals(end.replaceAll("X", ""))) return false;

        //"R" can move to the right until it is blocked by "L" while "L" can move to the left until it is blocked by "R".
        while(p1 < start.length() && p2 < end.length()) {
            while(p1 < start.length() && start.charAt(p1) == 'X') p1++;

            while(p2 < end.length() && end.charAt(p2) == 'X') p2++;

            if(p1 == start.length() && p2 == end.length()) return true;

            if(p1 == start.length() || p2 == end.length()) return false;

            if(start.charAt(p1) != end.charAt(p2)) return false;

            if(start.charAt(p1) == 'L' && p1 < p2) return false;

            if(start.charAt(p1) == 'R' && p1 > p2) return false;

            p1++;
            p2++;
        }
        while(p1 < start.length() && start.charAt(p1) == 'X') p1++;
        while(p2 < start.length() && end.charAt(p2) == 'X') p2++;
        return p1 == start.length() && p2 == end.length();
    }
}