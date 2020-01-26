package com.vc.medium;

import java.util.*;

class L267 {
    List<String> res = new ArrayList<>();
    public List<String> generatePalindromes(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int odd = 0;
        String oddCh = "";
        List<Character> cArr = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            int count = entry.getValue();
            if(count % 2 != 0) {
                odd++;
                oddCh = entry.getKey()+"";
            }
            for(int i = 0; i < count / 2; i++) cArr.add(entry.getKey());
        }

        if(odd > 1) return new ArrayList<String>();

        boolean[] visited = new boolean[cArr.size()];
        solve(new StringBuilder(), odd == 1 ? oddCh: "", cArr, visited);

        return res;
    }

    private void solve(StringBuilder sb, String odd, List<Character> arr, boolean[] visited) {
        if(sb.length() > arr.size()) return;
        if(sb.length() == arr.size()) {
            String str = sb.toString();
            res.add(str + odd + reverse(str));
            return;
        }
        for(int i = 0; i < arr.size(); i++) {
            if(visited[i]) continue;
            if(i > 0 && arr.get(i) == arr.get(i - 1) && !visited[i - 1]) continue;

            visited[i] = true;
            sb.append(arr.get(i));
            solve(sb, odd, arr, visited);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }

    private String reverse(String str) {
        char[] c = str.toCharArray();
        int left = 0;
        int right = c.length - 1;
        while(left < right) {
            char ch = c[left];
            c[left] = c[right];
            c[right] = ch;
            left++;
            right--;
        }
        return new String(c);
    }
}
