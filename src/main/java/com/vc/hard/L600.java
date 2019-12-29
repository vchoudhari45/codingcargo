package com.vc.hard;

class L600 {
    private int res = 0;
    public int findIntegers(int num) {
        dfs("1", num);
        return res + 1;
    }

    private void dfs(String prefix, int num) {
        if(Integer.parseInt(prefix, 2) <= num) {
            res++;
            if(prefix.charAt(prefix.length() - 1) == '0') {
                dfs(prefix + "1", num);
                dfs(prefix + "0", num);
            }
            else {
                dfs(prefix + "0", num);
            }
        }
    }
}
