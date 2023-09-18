package com.example.algorithms.leetcode.linkedlist

import com.example.algorithms.infrastructure.ListNode

/**
 * 1290
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/
 */
class BinaryNumberToInteger {
    var res = 0
    fun getDecimalValue(head: ListNode?): Int {
        return if (head == null) {
            res
        } else {
            res = res * 2 + head.`val`
            getDecimalValue(head.next)
        }
    }
}