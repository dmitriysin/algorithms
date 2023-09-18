package com.example.algorithms.leetcode

import kotlin.math.absoluteValue

/**
 * 735
 * https://leetcode.com/problems/asteroid-collision/description/
 */
class AsteroidCollision {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val aliveAsteroids = ArrayDeque<Int>(asteroids.size)

        for (asteroid in asteroids) {
            if (aliveAsteroids.isNotEmpty() && asteroid < 0) {
                var i = aliveAsteroids.size - 1

                while (aliveAsteroids.isNotEmpty()
                    && i >= 0
                    && aliveAsteroids.last() > 0
                    && aliveAsteroids.last() < asteroid.absoluteValue
                ) {
                    aliveAsteroids.removeLast()
                    i--
                }

                when {
                    aliveAsteroids.isEmpty() -> aliveAsteroids.add(asteroid)
                    aliveAsteroids.last() < 0 -> aliveAsteroids.add(asteroid)
                    aliveAsteroids.last() == asteroid.absoluteValue -> aliveAsteroids.removeLast()
                }

            } else {
                aliveAsteroids.add(asteroid)
            }
        }
        return aliveAsteroids.toIntArray()
    }
}