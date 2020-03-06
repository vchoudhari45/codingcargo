package com.vc.medium;

import java.util.*;

class L670 {
    public int maximumSwap(int num) {
        int[] digits = getDigits(num);
        int[] nge = new int[digits.length];
        Arrays.fill(nge, -1);
        Stack<Integer> st = new Stack<>();
        for(int i = digits.length - 1; i >= 0; i--) {
            if(!st.isEmpty() && digits[st.peek()] < digits[i]) {
                st.pop();
            }
            if(st.isEmpty()) st.push(i);
            else if(digits[st.peek()] != digits[i]) {
                nge[i] = st.peek();
            }
        }

        int index = 0;
        while(index < digits.length && nge[index] == -1) index++;

        if(index < digits.length) {
            int swap1 = index;
            int swap2 = nge[index];

            int temp = digits[swap1];
            digits[swap1] = digits[swap2];
            digits[swap2] = temp;
        }

        return getNum(digits);
    }

    private int getNum(int[] digits) {
        int n = 0;
        for(int i = 0; i < digits.length; i++) {
            n = n * 10 + digits[i];
        }
        return n;
    }

    private int[] getDigits(int n) {
        Stack<Integer> st = new Stack<>();
        while(n > 0) {
            int digit = n % 10;
            n = n / 10;
            st.push(digit);
        }
        int[] digits = new int[st.size()];
        int index = 0;
        while(!st.isEmpty()) digits[index++] = st.pop();
        return digits;
    }
}
