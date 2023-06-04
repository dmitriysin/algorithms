package com.example.algorithms.bst

internal interface SymbolTable<Key : Comparable<Key>, Value> {
    fun put(key: Key, value: Value)
    fun get(key: Key): Value?
    /*  fun min(): Key
     fun max(): Key
     fun floor(key: Key): Key
     fun select(rank: Int): Key
     fun rank(key: Key): Int*/
}