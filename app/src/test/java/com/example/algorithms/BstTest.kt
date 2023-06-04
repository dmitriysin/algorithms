package com.example.algorithms

import com.example.algorithms.bst.BST
import org.junit.Test

class BstTest {

    @Test
    fun testBst() {
        val bst = BST<Int, Char>()
        bst.put(1000, 'a')
        bst.put(900, 'b')
        bst.put(800, 'c')
        bst.put(810, 'f')
        bst.put(790, 'f')
        bst.put(910, 'e')
        bst.put(700, 'd')
        bst.put(1100, 'c')
        bst.put(1200, 'e')
        bst.put(1300, 'e')
        bst.put(1150, 'g')
        bst.put(1250, 'h')
        val g = bst.get(790)
        var res = 0
    }
}