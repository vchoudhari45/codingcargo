package com.vc.hard;

import java.util.*;

class Node212 {
    boolean isLeaf;
    HashMap<Character, Node212> map;

    Node212() {
        isLeaf = false;
        map = new HashMap<Character, Node212>();
    }
}

class Trie212 {
    Node212 root = new Node212();
    public void addWord(String word) {
        Node212 current = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!current.map.containsKey(ch)) current.map.put(ch, new Node212());
            current = current.map.get(ch);
        }
        current.isLeaf = true;
    }

    public boolean[] search(String word) {
        Node212 current = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(current.map.containsKey(ch)) current = current.map.get(ch);
            else return new boolean[]{false, false};
        }
        return new boolean[]{true, current.isLeaf};
    }
}

class Solution {
    Trie212 trie = new Trie212();

    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;
        for(String word: words) trie.addWord(word);

        HashSet<String> res = new HashSet<String>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                boolean[][] visited = new boolean[n][m];
                solve(i, j, board, new StringBuilder(), visited, res, n, m);
            }
        }
        return new ArrayList<String>(res);
    }

    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private void solve(int row, int col, char[][] board,
                       StringBuilder str, boolean[][] visited,
                       HashSet<String> res,
                       int n, int m) {
        if(!visited[row][col]) {
            visited[row][col] = true;
            str.append(board[row][col]);
            boolean[] search = trie.search(str.toString());

            if(!search[0]) {
                visited[row][col] = false;
                str.setLength(str.length() - 1);
                return;
            }
            else if(search[1]) res.add(str.toString());

            for(int[] dir: dirs) {
                int rowNew = row + dir[0];
                int colNew = col + dir[1];
                if(rowNew >= 0 && rowNew < n && colNew >= 0 && colNew < m) {
                    solve(rowNew, colNew, board, str, visited, res, n, m);
                }
            }
            visited[row][col] = false;
            str.setLength(str.length() - 1);
        }
    }
}
