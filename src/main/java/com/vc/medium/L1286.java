package com.vc.medium;

import java.util.*;

class CombinationIterator {

    private int n = 0;
    private char[] arr;
    private List<String> list;
    private int combinationLength = 0;
    private int index = 0;

    public CombinationIterator(String characters, int combinationLength) {
        this.n = characters.length();
        this.arr = characters.toCharArray();
        Arrays.sort(arr);
        this.list = new ArrayList<String>();
        this.combinationLength = combinationLength;
        solve(new StringBuilder(), 0);
    }

    private void solve(StringBuilder str, int index) {
        if(str.length() == combinationLength) list.add(str.toString());
        if(str.length() > combinationLength) return;
        for(int i = index; i < n; i++) {
            str.append(arr[i]);
            solve(str, i + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public String next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
