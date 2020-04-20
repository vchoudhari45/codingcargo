package com.vc.medium;

import com.vc.hard.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> st = new Stack<NestedInteger>();
    public NestedIterator(List<NestedInteger> nestedList) {
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
            NestedInteger e = st.peek();
            if(e.isInteger()) return true;
            else {
                List<NestedInteger> list = st.pop().getList();
                for(int i = list.size() - 1; i >= 0; i--) {
                    st.push(list.get(i));
                }
            }
        }
        return false;
    }
}
