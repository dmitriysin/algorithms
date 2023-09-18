package com.example.algorithms.leetcode.hashmap


/**
 * 49
 * https://leetcode.com/problems/group-anagrams/
 */
class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, MutableList<String>>()

        for (str in strs) {
            val arr = Array(26) { 0 }
            for (char in str) {
                val code = char - 'a'
                arr[code]++
            }
            val code = String(arr.map { it.toChar() }.toTypedArray().toCharArray())

            if (map[code] == null) map[code] = mutableListOf()
            map[code] = requireNotNull(map[code]).apply { add(str) }
        }

        val res = mutableListOf<List<String>>()
        for (entry in map) res.add(entry.value)

        return res
    }
}