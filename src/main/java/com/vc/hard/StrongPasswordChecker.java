package com.vc.hard;

class StrongPasswordChecker {
    public int strongPasswordChecker(String s) {
        int requiredChar = getRequiredChar(s);
        if (s.length() < 6) return Math.max(requiredChar, 6 - s.length());

        // only need replacement and deletion now when s.length() >= 6
        int replace = 0; // total replacements for repeated chars. e.g. "aaa" needs 1 replacement to fix
        int oned = 0; // total deletions for 3n repeated chars. e.g. "aaa" needs 1 deletion to fix
        int twod = 0; // total deletions for 3n + 1 repeated chars. e.g. "aaaa" needs 2 deletions to fix.

        for (int i = 0; i < s.length();){
            int len = 1; // repeated len
            while (i + len < s.length() && s.charAt(i + len) == s.charAt(i + len - 1)) len++;
            if (len >= 3){
                replace += len / 3;
                if (len % 3 == 0) oned += 1;
                if (len % 3 == 1) twod += 2;
            }
            i += len;
        }

        // no need deletion when s.length() <= 20
        if (s.length() <= 20) return Math.max(requiredChar, replace);

        int deleteCount = s.length() - 20;

        // deleting 1 char in (3n) repeated chars will save one replacement
        replace -= Math.min(deleteCount, oned);

        // deleting 2 chars in (3n + 1) repeated chars will save one replacement
        replace -= Math.min(Math.max(deleteCount - oned, 0), twod) / 2;

        // deleting 3 chars in (3n + 2) repeated chars will save one replacement
        replace -= Math.max(deleteCount - oned - twod, 0) / 3;

        return deleteCount + Math.max(requiredChar, replace);
    }

    private int getRequiredChar(String s) {
        int lowercase = 1, uppercase = 1, digit = 1;
        for(char c : s.toCharArray()){
            if (c >= 'a' && c <= 'z') lowercase = 0;
            else if (c >= 'A' && c <= 'Z') uppercase = 0;
            else if (c >= '0' && c <= '9') digit = 0;
        }
        return lowercase + uppercase + digit;
    }
}
