package com.whereismymoney.service;

/**
 * utility class that holds a pair of unmodifiable objects.
 * @author cxy
 *
 * @param <E> item1
 * @param <T> item2
 */
public class Pair<E, T> {
    private final E myItem1;
    private final T myItem2;
    
    public Pair(E item1, T item2) {
        myItem1 = item1;
        myItem2 = item2;
    }

    public E getItem1() {
        return myItem1;
    }

    public T getItem2() {
        return myItem2;
    }
}
