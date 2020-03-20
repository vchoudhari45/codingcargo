package com.vc.medium;

class L43 {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];

        int pos = m + n - 1;
        for(int i = m - 1; i >= 0; i--) {
            int position = pos;
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int sum = mul + res[position];
                res[position - 1] += sum / 10;
                res[position] = (sum) % 10;
                position--;
            }
            pos--;
        }

        StringBuilder sb = new StringBuilder();
        for(int p : res) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
