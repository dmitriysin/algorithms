package com.example.algorithms.leetcode


/**
 * 881
 * https://leetcode.com/problems/boats-to-save-people/
 */
class BoatsSavePeople {
    /**
     * [1,1,1,2,2,2,2,3,3,3,3,3] limit = 5
     */
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        var i = 0
        var j = people.lastIndex

        var res = 0
        while (j >= i) {
            if (people[j] < limit) {
                var weight = people[j]
                if (weight + people[i] <= limit) {
                    weight += people[i++]
                }
            }
            res++
            j--
        }
        return res
    }
}