package com.example.algorithms.infrastructure

object TreeNodeInstance {
    fun getRoot(): TreeNode {
        val root = TreeNode(25).apply {
            left = TreeNode(15).apply {
                left = TreeNode(10).apply {
                    left = TreeNode(4)
                    right = TreeNode(12)
                }
                right = TreeNode(22).apply {
                    left = TreeNode(18)
                    right = TreeNode(24)
                }
            }
            right = TreeNode(50).apply {
                left = TreeNode(35).apply {
                    left = TreeNode(31)
                    right = TreeNode(44)
                }
                right = TreeNode(70).apply {
                    left = TreeNode(90)
                    right = TreeNode(66)
                }
            }
        }

        return root
    }
}