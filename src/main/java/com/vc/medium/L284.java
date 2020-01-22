package com.vc.medium;

import java.util.*;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Integer current;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if(iterator.hasNext()) current = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return current;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res = current;
        if(iterator.hasNext()) current = iterator.next();
        else current = null;
        return res;
    }

    @Override
    public boolean hasNext() {
        if(current == null) return false;
        else return true;
    }
}