package com.vc.easy;

class L415 {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 && j >= 0) {
            int chi = num1.charAt(i) - '0';
            int chj = num2.charAt(j) - '0';
            int total = chi + chj + carry;
            int digit = total % 10;
            carry = total / 10;
            sb.insert(0, digit);
            i--;
            j--;
        }

        while(i >= 0) {
            int ch = num1.charAt(i) - '0';
            int total = ch + carry;
            int digit = total % 10;
            carry = total / 10;
            sb.insert(0, digit);
            i--;
        }

        while(j >= 0) {
            int ch = num2.charAt(j) - '0';
            int total = ch + carry;
            int digit = total % 10;
            carry = total / 10;
            sb.insert(0, digit);
            j--;
        }

        if(carry > 0)  sb.insert(0, carry);
        return sb.toString();
    }
}
