package com.vc.hard;

class L639 {
    int MOD = (int)1e9 + 7;
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0) return 0;

        long f1 = 1;                          //Seeding
        long f2 = helper(s.substring(0, 1)); //Encoded one digits
        for(int i = 1; i < n; i++) {
            long f3 = (f2 * helper(s.charAt(i)+"")) + (f1 * helper(s.substring(i - 1, i + 1)));
            f1 = f2;
            f2 = f3 % MOD;
        }
        return (int)f2;
    }

    private int helper(String s) {
        if(s.length() == 1) {
            if(s.charAt(0) == '*') return 9;
            else if(s.charAt(0) == '0') return 0; //Zero can't be decoded as anything on it's own
            else return 1;
        }
        else if(s.equals("**")) {
            return 15; //11 to 26 except 20
        }
        else if(s.charAt(0) == '*') {
            if(s.charAt(1) >= '0' && s.charAt(1) <= '6') return 2;
            else return 1;
        }
        else if(s.charAt(1) == '*'){
            if(s.charAt(0) == '1') return 9;
            else if(s.charAt(0) == '2') return 6;
            else return 0;
        }
        else {
            int num = Integer.parseInt(s);
            return (num >= 10 && num <= 26) ? 1 : 0;
        }
    }
}
