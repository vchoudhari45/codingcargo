package com.vc.hard;

class L660 {
    public int newInteger(int n) {
        String baseNine = Integer.toString(n, 9);
        //System.out.println(baseNine);
        return Integer.parseInt(baseNine);
    }
}
