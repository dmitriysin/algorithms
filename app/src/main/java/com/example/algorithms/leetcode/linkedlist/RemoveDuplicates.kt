package com.example.algorithms.leetcode.linkedlist

import com.example.algorithms.infrastructure.ListNode


/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
class RemoveDuplicates {

    var firstNode: ListNode? = null
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (firstNode == null) {
            firstNode = head
        }
        if (head?.next == null) {
            return firstNode
        }
        return if (head.`val` == requireNotNull(head.next).`val`) {
            head.next = head.next?.next
            deleteDuplicates(head)
        } else {
            deleteDuplicates(head.next)
        }
    }
}