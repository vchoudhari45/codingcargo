package com.vc.medium;

class L151 {
    public String reverseWords(String s) {
        s = s.trim().replaceAll("\\s+", " ");

        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length - 1; i >=0; i--) {
            sb.append(arr[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    private void reverse(char[] arr, int from, int to) {
        while(from < to) {
            char ch = arr[from];
            arr[from] = arr[to];
            arr[to] = ch;
            from++;
            to--;
        }
    }
}
