package com.vc.medium;

import java.util.HashMap;

class L166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0 || numerator == 0) return "0";

        long lnumerator = Math.abs(Long.valueOf(numerator));
        long ldenominator = Math.abs(Long.valueOf(denominator));

        StringBuilder fraction = new StringBuilder();
        if(numerator < 0 ^ denominator < 0) fraction.append("-");

        fraction.append(String.valueOf(lnumerator / ldenominator));

        if(lnumerator % ldenominator == 0) return fraction.toString();
        fraction.append(".");

        long remainder = lnumerator % ldenominator;
        HashMap<Long, Integer> map = new HashMap<>();
        while(remainder != 0) {
            if(map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                return fraction.toString();
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(remainder / ldenominator);
            remainder = remainder % ldenominator;
        }
        return fraction.toString();
    }
}
