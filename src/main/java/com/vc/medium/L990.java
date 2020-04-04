package com.vc.medium;

class L990 {
    public boolean equationsPossible(String[] equations) {
        int[] parentArr = new int[26];
        for(int i = 0; i < parentArr.length; i++) parentArr[i] = i;

        //Equality
        for(String equation: equations) {
            if(equation.charAt(1) == '!') continue;
            int var1 = equation.charAt(0) - 'a';
            int var2 = equation.charAt(3) - 'a';

            int var1Parent = find(var1, parentArr);
            int var2Parent = find(var2, parentArr);

            parentArr[var2Parent] = var1Parent;
        }

        //InEquality
        for(String equation: equations) {
            if(equation.charAt(1) == '=') continue;

            int var1 = equation.charAt(0) - 'a';
            int var2 = equation.charAt(3) - 'a';

            int var1Parent = find(var1, parentArr);
            int var2Parent = find(var2, parentArr);

            if(var1Parent == var2Parent) return false;
        }

        return true;
    }

    private int find(int x, int[] parentArr) {
        if(x == parentArr[x]) return x;
        else return parentArr[x] = find(parentArr[x], parentArr);
    }
}
