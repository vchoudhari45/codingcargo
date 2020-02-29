package com.vc.easy;

class L1085 {
    public int sumOfDigits(int[] A) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < A.length; i++) {
            min = Math.min(min, A[i]);
        }
        int sum = sumDigits(min);
        return sum % 2 == 0 ? 1 : 0;
    }

    private int sumDigits(int num) {
        int sum = 0;
        while(num > 0) {
            int digit = num % 10;
            sum += digit;
            num = num / 10;
        }
        return sum;
    }
}
