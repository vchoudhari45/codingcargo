package com.vc.hard;

class L440 {
    private int res = 0;
    private int current = 0;
    public int findKthNumber(int n, int k) {
        for(char ch = '1'; ch <= '9'; ch++) {
            solve(ch + "", n, k);
        }
        return res;
    }

    private void solve(String num, int n, int k) {
        int number = Integer.parseInt(num);
        if(number > n) return;
        else {
            current++;
            //System.out.println("number: "+number+" current: "+current);
            if(current == k) {
                res = number;
            }
            else {
                for(char ch = '0'; ch <= '9'; ch++) {
                    solve(num + ch, n, k);
                }
            }
        }
    }
}