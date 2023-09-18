package com.example.algorithms.leetcode.linkedlist

import com.example.algorithms.infrastructure.ListNode


/**
 * https://leetcode.com/problems/linked-list-cycle/
 */
object LinkedListCycle141 {

    var item = ListNode(0)
    fun hasCycle(head: ListNode?): Boolean {
        if (head?.next == null) return false
        if (head.next == item) return true
        val next = head.next
        head.next = item
        return hasCycle(next)
    }

    fun hasCycle1(head: ListNode?): Boolean {
        if (head?.next == null) return false
        var slow = head
        var fast = head.next
        while (fast != null) {
            slow = slow?.next
            fast = fast.next?.next
            if (slow == fast) return true
        }
        return false
    }
}




