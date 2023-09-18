package com.example.algorithms.leetcode.linkedlist

import com.example.algorithms.infrastructure.ListNode

/**
 * 86
 * https://leetcode.com/problems/partition-list/
 */
class PartitionList {
    fun partition(head: ListNode?, x: Int): ListNode? {
        val res = ListNode(-1)
        var less: ListNode? = null
        val moreFirst = ListNode(-1)
        var more: ListNode? = null
        var node = head
        while (node != null) {
            if (node.`val` < x) {
                less?.let {
                    it.next = node
                    less = less?.next
                } ?: run {
                    less = node
                    res.next = less
                }
            }
            if (node.`val` >= x) {
                more?.let {
                    it.next = node
                    more = more?.next
                } ?: run {
                    more = node
                    moreFirst.next = more
                }
            }
            node = node.next
        }
        more?.next = null
        less?.next = moreFirst.next
        return res.next ?: moreFirst.next
    }
}