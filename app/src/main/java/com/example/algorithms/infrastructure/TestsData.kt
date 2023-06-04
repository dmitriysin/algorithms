package com.example.algorithms.infrastructure

fun getLinkedList(): ListNode {
    val node6 = ListNode(6).apply { next = null }
    val node5 = ListNode(5).apply { next = node6 }
    val node4 = ListNode(4).apply { next = node5 }
    val node3 = ListNode(3).apply { next = node4 }
    val node2 = ListNode(2).apply { next = node3 }
    return ListNode(1).apply { next = node2 }
}
