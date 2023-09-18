package com.example.algorithms.infrastructure

class RandomProblem {
    fun getProblemNumber(): Int {
        val unsolvedProblems = intArrayOf(
            110,
            111,
            112,
            119,
            168,
            169,
            190,
            191,
            202,
            203,
            205,
            228,
            231,
            232,
            234,
            258,
            263,
            278,
            303,
            338,
            349,
            367,
            389,
            401,
            414,
        )

        val topQuestions = intArrayOf(
            4,
            5,
            10,
            15,
            22,
            23,
            36,
            38,
            41,
            42,
            44,
            48,
            50,
            53,
            54,
            62,
            75,
            76,
            84,
            91,
            103,
            104,
            105,
            108,
            116,
            124,
            127,
            130,
            131,
            134,
            138,
            140,
            146,
            148,
            149,
            150,
            152,
            169,
            179,
            189,
            204,
            208,
            210,
            212,
            218,
            236,
            239,
            289,
            295,
            297,
            300,
            315,
            322,
            324,
            328,
            329,
            341,
            347,
            378,
            380,
            384,
            395,
            454,
        )
        return topQuestions.random()
    }
}