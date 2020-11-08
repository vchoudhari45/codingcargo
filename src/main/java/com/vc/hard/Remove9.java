package com.vc.hard;

class Remove9 {
    public int newInteger(int n) {
        //Converting number to base 9 number
        String baseNine = Integer.toString(n, 9);
        return Integer.parseInt(baseNine);
    }
}
