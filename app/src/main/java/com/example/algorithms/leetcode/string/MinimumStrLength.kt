package com.example.algorithms.leetcode.string

class MinimumStrLength {
    fun minLength(s: String): Int {
        val deck = ArrayDeque<Char>(s.length)
        for (char in s) {
            deck.add(char)
            while (
                deck.size > 1
                && ((deck.last() == 'B' && deck[deck.lastIndex - 1] == 'A')
                        || (deck.last() == 'D' && deck[deck.lastIndex - 1] == 'C'))
            ) {
                deck.removeLast()
                deck.removeLast()
            }
        }

        return deck.size
    }
}