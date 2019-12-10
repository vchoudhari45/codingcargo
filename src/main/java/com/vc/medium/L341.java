package com.vc.medium;


import java.util.Iterator;
import java.util.List;
import java.util.Stack;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger341 {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger341> getList();
}

class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger341> st = new Stack<NestedInteger341>();
    public NestedIterator(List<NestedInteger341> nestedList) {
        for(int i = nestedList.size() - 1; i >= 0; i--) {
            st.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return st.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!st.isEmpty()) {
            NestedInteger341 e = st.peek();
            if(e.isInteger()) return true;
            else {
                List<NestedInteger341> list = st.pop().getList();
                for(int i = list.size() - 1; i >= 0; i--) {
                    st.push(list.get(i));
                }
            }
        }
        return false;
    }
}
