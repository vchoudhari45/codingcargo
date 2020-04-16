package com.vc.easy;

class L788 {
    public int rotatedDigits(int N) {
        int count = 0;
        for(int i = 1; i <= N; i++) {
            if(isValid(i)) count++;
        }
        return count;
    }

    private boolean isValid(int N) {
        boolean valid = false;
        while(N > 0) {
            int digit = N % 10;
            if(digit == 2 || digit == 5 || digit == 6 || digit == 9) valid = true;
            else if(digit == 3 || digit == 4 || digit == 7) return false;
            N = N / 10;
        }
        return valid;
    }
}
