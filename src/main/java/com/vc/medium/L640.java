package com.vc.medium;

class L640 {
    public String solveEquation(String equation) {
        String[] e = equation.split("=");
        int[] left = solve(e[0]);
        int[] right = solve(e[1]);

        //System.out.println("left: "+left[0]+" "+left[1]);
        //System.out.println("right: "+right[0]+" "+right[1]);

        int x = left[0] - right[0];
        int value = right[1] - left[1];

        //System.out.println(x+" "+value);

        if(x == 0 && value == 0) return "Infinite solutions";

        if(x == 0) return "No solution";

        if(x < 0) {
            x = -x;
            value = -value;
        }

        if(x > 1) {
            value = value / x;
            x = 1;
        }
        return "x="+value;
    }

    private int[] solve(String str) {
        str += '+';
        int x = 0;
        int value = 0;
        int index = 0;
        int sign = 1;

        String current = "";
        while(index < str.length()) {
            char ch = str.charAt(index);
            if(ch == '+' || ch == '-') {
                if(index == 0) {
                    if(ch == '+') sign = 1;
                    else sign = -1;
                    index++;
                    continue;
                }
                if(str.charAt(index - 1) == 'x') {
                    current = current.substring(0, current.length() - 1);
                    if(current.equals("")) x = x + sign;
                    else if(current.equals("-")) x = x - sign;
                    else x = x + sign * Integer.parseInt(current);
                }
                else value = value + sign * Integer.parseInt(current);
                current = "";
                if(ch == '+') sign = 1;
                else sign = -1;
            }
            else current += ch;
            index++;
        }
        return new int[]{x, value};
    }
}
