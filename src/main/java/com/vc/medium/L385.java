package com.vc.medium;


import java.util.*;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
class NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger(){

    }

    // Constructor initializes a single integer.
    public NestedInteger(int value){

    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger(){
        return false;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger(){
        return 1;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value){

    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni){

    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList(){
        return new ArrayList<NestedInteger>();
    }
}

class L385 {
    public NestedInteger deserialize(String s) {
        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            q.offer(s.charAt(i));
        }
        if(q.peek() == '[') q.poll();
        return solve(q);
    }

    private NestedInteger solve(Queue<Character> q) {
        NestedInteger res = new NestedInteger();
        String num = "";
        while(!q.isEmpty()) {
            char ch = q.poll();
            if(ch == '[') {
                NestedInteger ni = solve(q);
                res.add(ni);
            }
            else if(ch == ']' || ch == ',') {
                if(!num.equals("")) {
                    int n = Integer.parseInt(num);
                    NestedInteger ni = new NestedInteger(n);
                    res.add(ni);
                }
                num = "";
                if(ch == ']') break;
            }
            else num += ch;
        }
        if(!num.equals("")) {
            res.setInteger(Integer.parseInt(num));
        }
        return res;
    }
}
