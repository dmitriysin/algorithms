package com.example.algorithms.leetcode.dp

class GenerateParentheses {
    /**
     * {}
     * {}{}, {{}},
     * {{}{}}, {{{}}}, {{}}{}, {}{{}}, {}{}{}
     * {{{}{}}}, {{{{}}}}, {{}}{}, {}{{}}, {}{}{}
     */
    fun generateParenthesis(n: Int): List<String> {
        if (n == 1) return listOf("()")

        val set = LinkedHashSet<String>()
        val prev = generateParenthesis(n - 1)
        for (entry in prev) {
            "()$entry".let {
                if (set.contains(it).not()) set.add(it)
            }
            "$entry()".let {
                if (set.contains(it).not()) set.add(it)
            }
            set.add("($entry)")
        }
        return set.toList()
    }
}