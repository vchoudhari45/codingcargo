package com.vc.hard;

class NonNegativeIntegersWithoutConsecutiveOnes {
    public int findIntegers(int num) {
        char[] str = Integer.toBinaryString(num).toCharArray();
        int len = str.length;

        int endingInZero = 0;
        int endingInOne = 0;

        boolean isPrefixValid = true;
        for (int i = 0; i < len; i++) {
            //Fibonacci Series
            int total = endingInZero + endingInOne;

            // You can append one to only those seq where last digit was zero
            endingInOne = endingInZero;

            // You can append zero to any seq
            endingInZero = total;

            if (isPrefixValid) {
                if (str[i] == '1') {
                    endingInZero++;
                    if (i > 0 && str[i - 1] == '1') {
                        isPrefixValid = false;
                    }
                }
            }
        }
        return endingInZero + endingInOne + (isPrefixValid ? 1 : 0);
    }
}