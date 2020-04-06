package com.vc.medium;

class L357 {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        if(n == 1) return 10; //0,1,2,3,4,5,6,7,8,9

        int total = 10;
        int uniqueDigits = 9;       //9 because 0 can't be used as first digit
        int availableDigits = 9;    //Keeps on decreasing as number of digits in number increases
        for(int i = 2; i <= n; i++) {
            uniqueDigits = uniqueDigits * availableDigits--;
            total += uniqueDigits;
        }
        return total;
    }
}
