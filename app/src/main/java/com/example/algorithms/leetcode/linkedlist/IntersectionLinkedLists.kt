package com.example.algorithms.leetcode.linkedlist

import com.example.algorithms.infrastructure.ListNode

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 */
class IntersectionLinkedLists {
    private val setA = HashSet<ListNode>()
    private val setB = HashSet<ListNode>()
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        if (headA == headB) return headA
        when {
            headA != null && headB != null -> {
                setA.add(headA)
                if (setA.contains(headB)) return headB
                setB.add(headB)
                if (setB.contains(headA)) return headA
            }
            headA == null && headB != null -> {
                if (setA.contains(headB)) return headB
            }
            else -> {
                if (setB.contains(headA)) return headA
            }
        }
        return getIntersectionNode(headA?.next, headB?.next)
    }

    fun getIntersectionNode1(headA: ListNode?, headB: ListNode?): ListNode? {
        var lengthA = getLength(headA)
        var lengthB = getLength(headB)

        var nodeA = headA
        var nodeB = headB

        while (lengthA > lengthB) {
            nodeA = nodeA?.next
            lengthA--
        }

        while (lengthB > lengthA) {
            nodeB = nodeB?.next
            lengthB--
        }

        while (nodeA != null || nodeB != null) {
            if (nodeA == nodeB) return nodeA
            nodeA = nodeA?.next
            nodeB = nodeB?.next
        }

        return null
    }

    private fun getLength(list: ListNode?): Int {
        var i = 0
        var node = list
        while (node != null) {
            node = node.next
            i++
        }
        return i
    }
}