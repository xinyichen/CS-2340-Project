package com.whereismymoney.activity;

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
