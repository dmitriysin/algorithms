package com.example.algorithms.leetcode.dp

/**
 * 63
 * https://leetcode.com/problems/unique-paths-ii/
 */
class UniquePathsII {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val m = obstacleGrid.size
        val n = obstacleGrid[0].size
        val paths = Array(m) { IntArray(n) }

        var i = n - 1
        while (i >= 0) {
            if (obstacleGrid.last()[i] != 1) {
                paths.last()[i--] = 1
            } else {
                while (i >= 0) {
                    paths.last()[i--] = 0
                }
            }
        }
        var j = m - 1
        while (j >= 0) {
            if (obstacleGrid[j][n - 1] != 1) {
                paths[j--][n - 1] = 1
            } else {
                while (j >= 0) {
                    paths[j--][n - 1] = 0
                }

            }
        }

        for (k in m - 2 downTo 0) {
            var l = n - 2
            while (l >= 0) {
                if (obstacleGrid[k][l] == 1) {
                    paths[k][l] = 0
                } else {
                    paths[k][l] = paths[k + 1][l] + paths[k][l + 1]
                }
                l--
            }
        }
        return paths[0][0]
    }

    private fun findPath(obstacleGrid: Array<IntArray>, x: Int, y: Int): Int {
        return when {
            y !in obstacleGrid.indices || x !in obstacleGrid[y].indices -> 0
            obstacleGrid[y][x] == 1 -> 0
            x == obstacleGrid.last().lastIndex && y == obstacleGrid.lastIndex -> 1
            else -> findPath(obstacleGrid, x + 1, y) + findPath(obstacleGrid, x, y + 1)
        }
    }
}