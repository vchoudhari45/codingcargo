package com.vc.medium;

class L393 {
    public boolean validUtf8(int[] data) {
        int i = 0;
        while(i < data.length) {
            String binary = binaryString(data, i);
            if(binary.charAt(0) != '0') {
                int n = 0;
                while(n < binary.length() && binary.charAt(n) == '1') n++;

                if(n == 1 || n > 4 || binary.charAt(n) != '0') return false;

                if(i + n - 1 >= data.length) return false;
                for(int k = 1; k < n; k++) {
                    binary = binaryString(data, i + k);
                    if(binary.charAt(0) != '1' || binary.charAt(1) != '0') return false;
                }
                i = i + n - 1;
            }
            i++;
        }
        return true;
    }

    private String binaryString(int[] data, int i) {
        String binary = Integer.toBinaryString(data[i]);
        binary = binary.length() > 8 ? binary.substring(binary.length() - 8) :
                ("00000000" + binary).substring(binary.length());
        return binary;
    }
}
