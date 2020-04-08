package com.vc.easy;

class L67 {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        StringBuilder sb = new StringBuilder();
        int carry = 0;

        while(i >= 0 && j >= 0) {
            char cha = a.charAt(i--);
            char chb = b.charAt(j--);

            if(cha == '1' && chb == '1') {
                if(carry == 1) sb.insert(0, '1');
                else if(carry == 0) sb.insert(0, '0');
                carry = 1;
            }
            else if((cha == '1' && chb == '0') || (cha == '0' && chb == '1')) {
                if(carry == 1) {
                    sb.insert(0, '0');
                    carry = 1;
                }
                else {
                    sb.insert(0, '1');
                    carry = 0;
                }
            }
            else if(cha == '0' && chb == '0') {
                if(carry == 1) sb.insert(0, '1');
                else sb.insert(0, '0');
                carry = 0;
            }
        }

        while(i >= 0) {
            char cha = a.charAt(i--);
            if(cha == '1') {
                if(carry == 1) {
                    sb.insert(0, '0');
                    carry = 1;
                }
                else {
                    sb.insert(0, '1');
                    carry = 0;
                }
            }
            else {
                if(carry == 1) {
                    sb.insert(0, '1');
                    carry = 0;
                }
                else {
                    sb.insert(0, '0');
                    carry = 0;
                }
            }
        }

        while(j >= 0) {
            char chb = b.charAt(j--);
            if(chb == '1') {
                if(carry == 1) {
                    sb.insert(0, '0');
                    carry = 1;
                }
                else {
                    sb.insert(0, '1');
                    carry = 0;
                }
            }
            else {
                if(carry == 1) {
                    sb.insert(0, '1');
                    carry = 0;
                }
                else {
                    sb.insert(0, '0');
                    carry = 0;
                }
            }
        }

        if(carry > 0) sb.insert(0, carry);
        return sb.toString();
    }
}
