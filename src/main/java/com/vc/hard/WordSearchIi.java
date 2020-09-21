package com.vc.hard;

import java.util.*;

class WordSearchIi {
    class Node {
        String word;
        HashMap<Character, Node> map;

        Node() {
            map = new HashMap<>();
        }
    }

    class Trie {
        Node root = new Node();
        public void addWord(String str) {
            Node current = root;
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(!current.map.containsKey(ch)) current.map.put(ch, new Node());
                current = current.map.get(ch);
            }
            current.word = str;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {

        HashSet<String> res = new HashSet<>();

        Trie trie = new Trie();
        for(String word: words) trie.addWord(word);

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(trie.root.map.containsKey(board[i][j]))
                    solve(i, j, board, trie.root, res);
            }
        }

        return new ArrayList<>(res);
    }

    private int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private void solve(int row, int col, char[][] board, Node node, HashSet<String> res) {
        Node nodeNew = node.map.get(board[row][col]);

        if(nodeNew.word != null) {
            res.add(nodeNew.word);
        }

        char ch = board[row][col];
        board[row][col] = '#';

        for(int[] dir: dirs) {
            int rowNew = row + dir[0];
            int colNew = col + dir[1];
            if(rowNew >= 0 && rowNew < board.length && colNew >= 0 && colNew < board[0].length) {
                if(nodeNew.map.containsKey(board[rowNew][colNew]))
                    solve(rowNew, colNew, board, nodeNew, res);
            }
        }

        board[row][col] = ch;
    }
}