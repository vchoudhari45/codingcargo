package com.vc.hard;

class L902 {
    public int atMostNGivenDigitSet(String[] options, int N) {
        String s = String.valueOf(N);
        int len = s.length();

        int lessDigits = 0;
        //For e.g. let's Say N = 164 and options [1, 2, 3, 4]
        //For all 1 digit numbers there are 4 options
        //For all 2 digit numbers there 4 * 4 possiblities = 16
        for(int i = 1; i < len; i++) {
            //Here i is count of digits in number generated
            lessDigits += (int)Math.pow(options.length, i);
        }

        //For all the number with same number of digits as in N
        //we have to select a digit smaller or equal to digit in N
        int[] slots = new int[len + 1];
        slots[len] = 1;
        for(int slot = len - 1; slot >= 0; slot--) {
            int digit = s.charAt(slot) - '0';
            for(String option: options) {
                if(digit > Integer.parseInt(option)) {
                    //For all the slots to right side of this slot can have options.length possibilities
                    slots[slot] += (int) Math.pow(options.length, len - slot - 1);
                }
                else if(digit == Integer.parseInt(option)){
                    slots[slot] += slots[slot + 1];
                }
            }
        }
        return lessDigits + slots[0];
    }
}