package com.vc.hard;

import java.util.*;

class L1307 {
    boolean found = false;

    public boolean isSolvable(String[] words, String result) {
        HashSet<Character> all = new HashSet<>();
        HashSet<Character> starts = new HashSet<>();
        /*
            Char appearing at the start can't be assigned zero
            For e.g. S in SEND can't be assigned 0
        */
        for(String str: words) {
            if(str.length() > result.length()) return false;
            int index = 0;
            for(char ch: str.toCharArray()) {
                if(index == 0) starts.add(ch);
                index++;
                all.add(ch);
            }
        }

        int index = 0;
        for(char ch: result.toCharArray()) {
            if(index == 0) starts.add(ch);
            index++;
            all.add(ch);
        }

        char[] arr = new char[all.size()];
        boolean[] visited = new boolean[10];
        index = 0;
        for(Character s: all) arr[index++] = s;

        int[] map = new int[128];
        solve(arr, 0, visited, starts, map, words, result);

        return found;
    }

    private boolean solve(char[] arr, int index, boolean[] visited,
                          HashSet<Character> starts,
                          int[] map, String[] words, String result) {
        if(found) return true;
        if(index == arr.length) return isValid(map, words, result);

        for(int digit = 0; digit < visited.length; digit++) {
            char charToBeAssigned = arr[index];

            if(visited[digit] || (digit == 0 && starts.contains(charToBeAssigned))) continue;

            visited[digit] = true;
            map[charToBeAssigned] = digit;
            if(solve(arr, index + 1, visited, starts, map, words, result)) {
                found = true;
                return true;
            }
            map[charToBeAssigned] = 0;
            visited[digit] = false;
        }
        return false;
    }

    private boolean isValid(int[] map, String[] words, String result) {
        int sum = 0;
        for(String word : words) {
            int num = 0;
            for(char c : word.toCharArray()) {
                num = num * 10 + map[c];
            }
            sum += num;
        }

        int num = 0;
        for(char c : result.toCharArray()) {
            num = num * 10 + map[c];
        }

        return num == sum;
    }
}
