package com.vc.hard;

class L839 {
    public int numSimilarGroups(String[] arr) {
        int n = arr.length;
        if(n == 0) return 0;
        int[] parentArr = new int[n];

        for(int i = 0; i < parentArr.length; i++) parentArr[i] = i;

        int res = n;
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++) {
                //System.out.println("\nComparing "+arr[i]+" with "+arr[j]);
                if(isSimilar(i, j, arr)) {
                    //System.out.println(arr[i]+" and "+arr[j]+" are similar");
                    int pi = find(i, parentArr);
                    int pj = find(j, parentArr);
                    parentArr[pi] = pj;
                    if(pi != pj) res--;
                }
            }
        }

        return res;
    }

    private boolean isSimilar(int i, int j, String[] arr) {
        int count = 0;
        String s1 = arr[i];
        String s2 = arr[j];
        for(int index = 0; index < s1.length(); index++) {
            if(s1.charAt(index) != s2.charAt(index)) {
                count++;
                if(count > 2) return false;
            }
        }
        return true;
    }

    private int find(int p, int[] parentArr) {
        if(parentArr[p] == p) return p;
        else return parentArr[p] = find(parentArr[p], parentArr);
    }
}